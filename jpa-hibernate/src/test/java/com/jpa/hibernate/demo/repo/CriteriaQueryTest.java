  package com.jpa.hibernate.demo.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.jsonpath.Predicate;
import com.jpa.hibernate.demo.JpaDemoApplication;
import com.jpa.hibernate.demo.entity.Course;
import com.jpa.hibernate.demo.entity.Student;
import com.jpa.hibernate.demo.entity.passport;

import aj.org.objectweb.asm.Type;
@RunWith(SpringRunner.class)

@SpringBootTest(classes=JpaDemoApplication.class)
public class CriteriaQueryTest {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	@Test
	public void JpqlBasic() {
		// select c from Course c  (Change into Criteria Query)
	    System.err.println("JPQL is running");
//	    Step-1:use criteria Builder to create a criteria Query returning the expected result  object
	    CriteriaBuilder cb=em.getCriteriaBuilder();
	    CriteriaQuery<Course> cq= cb.createQuery(Course.class);
	    
//	    Step-2: Define root for table which are involve in the Query
	   Root<Course> courseRoot= cq.from(Course.class);
//	   Step-3: Define Predicates etc using criteria Builder
	   // write here your logic and 
//	   Step-4:Build the typed Query using the entity manager and criteria query
        TypedQuery<Course> query=em.createQuery(cq.select(courseRoot));
        List<Course> courseList=query.getResultList();
        logger.info("get All Course using criterial Query====>"+courseList.size());
}
	@Test
	public void all_Course_Have_Pattern() {
		//Select s from student s where name like '%java% or email='abc'' 
		System.err.println("Course have A pattern");
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Course> cq=cb.createQuery(Course.class);
	    Root<Course> courseRoot=cq.from(Course.class);
//		   Step-3: Define Predicates etc using criteria Builder
	 //cq.where(cb.equal(courseRoot.get("email"), "abc"));
	  cq.where(cb.or(cb.equal(courseRoot.get("email"), "abc"),cb.like(courseRoot.get("name"), "%java%")));
	  TypedQuery<Course> query=em.createQuery(cq.select(courseRoot));
	  
	  logger.info("course===>"+query.getResultList().size());

	
	}
	@Test
	public void getAllCourseWithoutStudent() {
		//Select c from Course c where c.student is empty
		System.err.print("get course without student");
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Course> cq=cb.createQuery(Course.class);
		Root<Course> courseRoot=cq.from(Course.class);
		cq.where(cb.isEmpty(courseRoot.get("student")));
		TypedQuery<Course> result=em.createQuery(cq.select(courseRoot));
		logger.info("Get All Course without Student====>>>>>"+result.getResultList().size());
	}
	@Test
	public void joinCriteriaQuery() {
		//Select c , s from Student c  JOIN c.courses s
		System.err.println("Join Criteria Query");
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Course> cq=cb.createQuery(Course.class);
		Root<Course> courseRoot=cq.from(Course.class);
		Join<Object, Object> join=courseRoot.join("student");
		TypedQuery<Course> joinResult=em.createQuery(cq.select(courseRoot));
		logger.info("Join Criteria Query=======>>>>>>"+joinResult.getResultList().size());
	}
	/*
	 * @Test public void jpqlType() { TypedQuery<Course>
	 * course=em.createNamedQuery("query_get_all_courses",Course.class);
	 * List<Course> resultList=course.getResultList();
	 * logger.info("Select c from Course c -->{}",resultList); }
	 * 
	 * @Test public void jpqlWhere()
	 * 
	 * { System.err.println("named query"); TypedQuery<Course>
	 * course=em.createNamedQuery("query_get_courses",Course.class); List<Course>
	 * resultList=course.getResultList();
	 * logger.info("Select c from Course c  where name=ranjeet -->{}",resultList); }
	 * 
	 * @Test public void QueryforCourseWithoutStudent() {
	 * System.err.print("Named Query"); TypedQuery<Course>
	 * course=em.createQuery("Select c from Course c where c.student is empty",
	 * Course.class); List<Course> courseList=course.getResultList();
	 * logger.info("Course Without Student====>>>{}"+courseList.size());
	 * 
	 * }
	 * 
	 * @Test public void QueryforAtLeastTwoStudent() {
	 * System.err.println("At Least Two student"); TypedQuery<Course>
	 * leastStudent=em.createNamedQuery("at_least_two_student", Course.class);
	 * List<Course> least2Student=leastStudent.getResultList();
	 * logger.info("atLeast2Student===>"+least2Student.size()); }
	 * 
	 * @Test public void OrderdBystudent() {
	 * System.err.println("ordered By student");
	 * 
	 * TypedQuery<Course> orderStudent=em.createNamedQuery("order_by_student",
	 * Course.class); List<Course> orderedStudent=orderStudent.getResultList();
	 * logger.info("atLeast2Student===>"+orderedStudent.size());
	 * 
	 * }
	 * 
	 * @Test public void passportWithCertainPattern() {
	 * System.err.println("passport Pattern"); TypedQuery<Student>
	 * passport=em.createNamedQuery("Passport_name_with_certain_code",
	 * Student.class); List<Student> passportOrder=passport.getResultList();
	 * logger.info("passport statrt with ====>>>>>"+passportOrder.size()); }
	 * 
	 * @Test public void join(){ System.err.println("join in jpql"); Query
	 * studentInfo=em.createQuery("Select c , s from Student c  JOIN c.courses s");/
	 * /we can join using reverse entity either student or Course because both are
	 * mapped return array of array List<Object[]>
	 * studentInfoList=studentInfo.getResultList();
	 * logger.info("Get student info using Join query=========>>>>>>>>>>"
	 * +studentInfoList.size()); for(Object[] InfoList: studentInfoList) { logger.
	 * info("InfoList[0] return course array and {}InfoList[1] //return student info aaray;/n"
	 * + InfoList[0]+"/n"+InfoList[1]); } }
	 * 
	 * @Test public void leftJoin() { System.err.print("Left Join"); Query
	 * studentInfoLeftJoin=em.
	 * createQuery("Select s,c from Course c LEFT JOIN c.student s"); List
	 * studentInfo=studentInfoLeftJoin.getResultList();
	 * logger.info("Student info using left join===>>>"+studentInfo.size()); }
	 * 
	 * @Test public void crossJoin() { System.err.println("crossJoin"); Query
	 * infoUsingCrossJoin=em.createQuery("Select s,c from Course c, Student s");
	 * List studentInfo=infoUsingCrossJoin.getResultList();
	 * logger.info("Student info using cross join "+studentInfo.size()); }
	 */
	
}

 package com.jpa.hibernate.demo.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.hibernate.demo.JpaDemoApplication;
import com.jpa.hibernate.demo.entity.Course;
import com.jpa.hibernate.demo.entity.Student;
import com.jpa.hibernate.demo.entity.passport;
@RunWith(SpringRunner.class)

@SpringBootTest(classes=JpaDemoApplication.class)
public class JpqlTest {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	@Test
	public void JpqlBasic() {
	System.err.println("JPQL is running");
		List course =em.createNamedQuery("query_get_all_courses").getResultList();
		logger.info("Select c from Course c -->{}", course);
		
}
	@Test
	public void jpqlType() {
		TypedQuery<Course> course=em.createNamedQuery("query_get_all_courses",Course.class);
		List<Course> resultList=course.getResultList();
		logger.info("Select c from Course c -->{}",resultList);
	}
	
	@Test
	public void jpqlWhere()
	
	{
		System.err.println("named query");
		TypedQuery<Course> course=em.createNamedQuery("query_get_courses",Course.class);
		List<Course> resultList=course.getResultList();
		logger.info("Select c from Course c  where name=ranjeet -->{}",resultList);
	}
	@Test
	public void QueryforCourseWithoutStudent()
	{
		 System.err.print("Named Query");
		 TypedQuery<Course> course=em.createNamedQuery("query_get_course_without_student", Course.class);
		 List<Course> courseList=course.getResultList();
		 logger.info("Course Without Student====>>>{}"+courseList);
		  
	}
	@Test
	public void QueryforAtLeastTwoStudent()
	{
		System.err.println("At Least Two student");
		TypedQuery<Course> leastStudent=em.createNamedQuery("at_least_two_student", Course.class);
		List<Course> least2Student=leastStudent.getResultList();
		logger.info("atLeast2Student===>"+least2Student);
	}
	@Test
	public void OrderdBystudent() {
		System.err.println("ordered By student");
		  
		TypedQuery<Course> orderStudent=em.createNamedQuery("order_by_student", Course.class);
		List<Course> orderedStudent=orderStudent.getResultList();
		logger.info("atLeast2Student===>"+orderedStudent);

	}
	@Test
	public void passportWithCertainPattern() {
		System.err.println("passport Pattern");
		TypedQuery<Student> passport=em.createNamedQuery("Passport_name_with_certain_code", Student.class);
	    List<Student> passportOrder=passport.getResultList();
	    logger.info("passport statrt with ====>>>>>"+passportOrder);
	}
	
}

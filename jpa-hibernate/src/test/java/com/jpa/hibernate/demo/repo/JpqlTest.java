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
	
}

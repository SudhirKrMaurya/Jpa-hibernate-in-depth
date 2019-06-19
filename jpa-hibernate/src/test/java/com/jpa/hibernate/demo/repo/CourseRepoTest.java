package com.jpa.hibernate.demo.repo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.hibernate.demo.JpaDemoApplication;
import com.jpa.hibernate.demo.entity.Course;
import com.jpa.hibernate.demo.entity.Rating;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaDemoApplication.class)
public class CourseRepoTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepo courseRepo;
	@Autowired
	EntityManager em;
	
	@Test
	@DirtiesContext
	public void contextLoads() {
		System.err.println("Test class");
		logger.info("test is running");
		Course course=courseRepo.findById(3);
		assertEquals("ranjeet", course.getName());
		assertEquals("ranjeet.nityanand@picsaxis.com", course.getEmail());
		assertEquals("1234567890", course.getContatct());
		//assertNull(courseRepo.deleteById(1));
	}
	@Test
	@DirtiesContext
	public void deleteTest()
	{
		System.err.println("delete test");
		courseRepo.deleteById(3);
		assertNull(courseRepo.findById(2));
	}
	
	@Test
	@DirtiesContext
	public void playWithEntity() 
	{
		
		courseRepo.playWithEntityManager();
		{
			
			System.err.println("play with entity manager");
		}
		
	}
	
	  //This block is facing version problem
	  
	  @Test 
	  @Transactional
	  public void retriewreviewForCourse()
	  { 
		  Course course=courseRepo.findById(2);
		 
	  logger.info("Course review===>"+course.getRating());
	  
	  
	  }
	  @Test 
	  @Transactional
	  public void reviewForCourse()
	  { 
		 Rating review =em.find(Rating.class, 2);
	    logger.info("rating review===>"+review);
	  
	  
	  }
	  @Test 
	  @Transactional
	  public void reviewForCourseAndStudent()
	  { 
		 Course course =em.find(Course.class,2);
		    logger.info("Student ===>"+course.getStudent().get(0).getName()+" student Id=>"+course.getStudent().get(0).getId());
	    logger.info("Student and Course Details===>"+course.getStudent().toString());
	  
	  
	  }
	 
	

}

package com.jpa.hibernate.demo.repo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaDemoApplication.class)
public class CourseRepoTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepo courseRepo;
	@Test
	@DirtiesContext
	public void contextLoads() {
		logger.info("test is running");
		Course course=courseRepo.findById(1);
		assertEquals("sudhir", course.getName());
		assertEquals("sudhir@gmail.com", course.getEmail());
		assertEquals("8923496827", course.getContatct());
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

}

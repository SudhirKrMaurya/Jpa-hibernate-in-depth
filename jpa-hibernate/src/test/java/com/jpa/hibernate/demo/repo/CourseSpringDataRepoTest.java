package com.jpa.hibernate.demo.repo;


import java.util.Optional;

import javax.persistence.Query;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.hibernate.demo.JpaDemoApplication;
import com.jpa.hibernate.demo.entity.Course;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaDemoApplication.class)
public class CourseSpringDataRepoTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataRepo courseSpringRepo;
	
	@Test
	public void findById_course_Present() {
 		 Optional<Course> course= courseSpringRepo.findById(2);  //optional provide to way check course present or not means NULLPointerException problem solve by java 1.8 version
		logger.info("Spring data find by Id====>"+course.isPresent());//return true
	}
	@Test
	public void findById_course_not_Present() {
		 Optional<Course> course= courseSpringRepo.findById(0);  //Check course is null means not found any value
		logger.info("Spring data find by Id is null====>"+course.isPresent());// return false
	}
	
	@Test
	public void springDataOperation() {
		Course  course=new Course("Go by google");
		Course coursereturn= courseSpringRepo.save(course);
		logger.info("Course details save successfuly"+coursereturn);
	//	Course updated=new Course("go by google-updated version");
		course.setName(" updated course of go ");
		Course updateReturn=courseSpringRepo.save(course);// update the course name
		logger.info("updated course value====>>>>"+updateReturn);
		
	}
	
	@Test
	public void findAll()
	{
		logger.info("find all of course value===>>>"+courseSpringRepo.findAll().size());
		logger.info("Count course value===>>>"+courseSpringRepo.count());

	}
	@Test
	public void sort() {
		Sort sort=new Sort(Sort.Direction.DESC,"name");
		logger.info("sort all course name in desending order==========>>>>"+sort);
		/*
		 * int value=-5; System.err.println("value==="+value);
		 */
 	}
	
	@Test
	public void pagination() {
		PageRequest pages=new PageRequest(0, 5);
		Page<Course> firstPage=courseSpringRepo.findAll(pages);
		logger.info("first page=====>>"+firstPage.getContent());
		Pageable secondpage=firstPage.nextPageable();
		Page<Course> nextPages=courseSpringRepo.findAll(secondpage);
		logger.info("Second page of paginatiuon=====>>>"+nextPages.getSize());
		
	}
	@Test
	public void findByName() {
		System.err.println("find by name");
		logger.info("course find by name======>>>>>>"+courseSpringRepo.findByName("go by google").size());
	}
	/*
	 * @Test public void deleteByName() { System.err.println("delete by name");
	 * logger.info("Delete by Name=========>>>>>>>>"+courseSpringRepo.
	 * deleteByName("go by google updated").size()); }
	 */
	@Test
	public void FindByNameAndId() {
		System.err.print("find by name and Id");
		logger.info("find by name and Id=====>>>>"+courseSpringRepo.findByNameAndId("Go By Google", 43).size());
	}
	@Test
	public void findByJpaQuery()
	{
		System.err.println("find By Jpa Query");
		logger.info("Find By JPA Query=====>>>>>"+courseSpringRepo.findByQuery().size());
	}
	@Test
	public void findByNativeQuery() {
		System.err.print("find by native Query");
		logger.info("find by native Query====>>>>"+courseSpringRepo.findBynativeQuery().size());
	}
} 

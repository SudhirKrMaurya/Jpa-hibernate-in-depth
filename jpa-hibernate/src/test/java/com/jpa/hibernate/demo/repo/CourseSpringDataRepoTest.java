package com.jpa.hibernate.demo.repo;


import java.util.Optional;

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
} 

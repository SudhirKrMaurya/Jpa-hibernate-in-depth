 package com.jpa.hibernate.demo.repo;



import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.demo.entity.Course;
import com.jpa.hibernate.demo.entity.Rating;

import ch.qos.logback.classic.Logger;
@Repository
@Transactional
public class CourseRepo {
	
	@Autowired
	EntityManager em;
	
	public Course findById(int id) {
		return em.find(Course.class, id);
		
		
	}
	public void deleteById(int id) {
		Course course=findById(id);
	     em.remove(course);
	}
	
	public Course insert(Course course)
	
	{
		if(course.getId() == null)
		{
			em.persist(course);
		}
		else {
		 em.merge(course);
		}
		 return course;
		
	}
	
	public void playWithEntityManager()
	{
	 Course course1=new Course("Web service lecture");
	 Course course2=new Course("java script lect.");
	 em.persist(course2); 
	 em.persist(course1);
	 em.flush();
	 
	 //em.clear();
	 
	 //em.detach(course2);
	 course1.setName("web service lecture updated");
	 course2.setName("java script lect.  =updated");
	 em.refresh(course1);
	 em.flush();
	}
	public void addReviewForCourse(int courseId) {
		// step
		//1.find course details by ID
		Course course=findById(courseId);
		System.err.println("course.getrating===>"+course.getRating());
		
		//2.add two review in it
		Rating rating1=new Rating(4,"good");
		Rating rating2=new  Rating(5,"best");
		
		//3.setting the relationship
		course.addRating(rating1);
		rating1.setCourse(course);
		
		course.addRating(rating2);
		rating2.setCourse(course);
		
		
		//4.save in database
		em.persist(rating1);
		em.persist(rating2);
		
	}
	public void addHardCodedReviewForCourse(int courseId,List<Rating> rating) {
		// step
		//1.find course details by ID
		Course course=findById(courseId);
		System.err.println("course.getrating===>"+course);
		for(Rating review:rating) {
		//2.add two review in it
		
		course.addRating(review);
		review.setCourse(course);
		//4.save in database
		em.persist(review);
	
		}
	}
	

}

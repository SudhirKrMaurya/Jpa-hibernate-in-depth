 package com.jpa.hibernate.demo.repo;



import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.demo.entity.Course;
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

}

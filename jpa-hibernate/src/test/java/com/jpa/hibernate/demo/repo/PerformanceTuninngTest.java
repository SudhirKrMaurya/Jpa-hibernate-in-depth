package com.jpa.hibernate.demo.repo;
import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.transaction.Transactional;

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
public class PerformanceTuninngTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepo courseRepo;
	@Autowired
	EntityManager em;
	@Test
@Transactional
	public void getAllCourse_One_plusProblem() 
	{
		List<Course> allcourse=em.createNamedQuery("query_get_all_courses", Course.class).getResultList();
		logger.info(" performance of All course {} ",allcourse);
		for(Course course:allcourse) {
			System.err.println("course name==>"+course.getName());
		}
	}
	@Test
	@Transactional
		public void solve_One_Plus_OneProblem() 
		{
	    	EntityGraph<Course> createEntityGraph=em.createEntityGraph(Course.class);
	    	Subgraph<Object> subgraph=createEntityGraph.addSubgraph("student");
			List<Course> allcourse=em.createNamedQuery("query_get_all_courses", Course.class).setHint("javax.persistance.loadgraph", createEntityGraph)
					.getResultList();
			logger.info(" performance of All course {} ",allcourse);
			for(Course course:allcourse) {
				System.err.println("course name==>"+course.getName());
			}
		}

}

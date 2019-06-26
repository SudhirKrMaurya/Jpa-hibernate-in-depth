package com.jpa.hibernate.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jpa.hibernate.demo.entity.Course;
@RepositoryRestResource(path = "Course")
  public interface CourseSpringDataRepo extends JpaRepository<Course, Integer>{


	 Optional<Course> findById(Integer i);
	 List<Course> findByName(String name);
	 List<Course> findByNameAndId(String name,int id);
	 
	 @Query(value="select c from Course c where name='Go by Google'")
	 List<Course>findByQuery();    // JPA Query
	 
	 @Query(value="select * from Course  where name='Go by Google'",nativeQuery = true)
	 List<Course>findBynativeQuery();

	 

}

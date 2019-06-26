package com.jpa.hibernate.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpa.hibernate.demo.entity.Course;
  public interface CourseSpringDataRepo extends JpaRepository<Course, Integer>{


	 Optional<Course> findById(Integer i);

}

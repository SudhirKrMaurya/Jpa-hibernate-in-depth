package com.jpa.hibernate.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.demo.entity.Student;
@Repository
public interface IRepository extends JpaRepository<Student, Integer> {

	Student findStudentByName(String name);

}

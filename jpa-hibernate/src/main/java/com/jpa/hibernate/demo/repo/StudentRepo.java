package com.jpa.hibernate.demo.repo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.demo.entity.Student;

@Repository
@Transactional
public class StudentRepo {
	@Autowired
	EntityManager em;
	
	public Student FindyById(int id) {
		return em.find(Student.class,id);
		
	}

}

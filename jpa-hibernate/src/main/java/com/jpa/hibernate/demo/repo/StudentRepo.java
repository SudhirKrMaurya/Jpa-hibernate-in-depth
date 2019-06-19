package com.jpa.hibernate.demo.repo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.demo.entity.Student;
import com.jpa.hibernate.demo.entity.passport;

@Repository
@Transactional
public class StudentRepo {
	@Autowired
	EntityManager em;
	
	public Student findById(int id) {
		return em.find(Student.class,id);
	}
	
	public void deleteById(int id) {
		Student student=findById(id);
		em.remove(student);
		
	}
	public Student addmission(Student student) {
		if(student.getId()==null) {
			em.persist(student);
		}
		else {
			em.merge(student);
		}
		
		return student;
		
	}
	
	public void studentWithpassport() {
        passport passport=new passport("IND0021165");
		em.persist(passport);
		Student student=new Student("sudhir");
		student.setPassport(passport);
		em.persist(student);
		
		
	}
	
 
}

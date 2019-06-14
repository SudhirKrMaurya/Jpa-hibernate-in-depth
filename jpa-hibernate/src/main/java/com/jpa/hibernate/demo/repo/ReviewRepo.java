package com.jpa.hibernate.demo.repo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.demo.entity.Rating;

@Repository
@Transactional
public class ReviewRepo {
	@Autowired
	EntityManager em;
	String sql="Select";
	public Rating reviewById(int id) {
		return em.find(Rating.class, id);
		
	}
}

package com.jpa.hibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.demo.entity.Course;
import com.jpa.hibernate.demo.repo.CourseRepo;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{
	@Autowired
	 CourseRepo repo;
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("find by id-->{}",repo.findById(1));
		//logger.info("insert info in db-->{}",repo.insert(new Course("nitu","ranjeetneetu@gamil.com","gurugaon","8520852369")));
		
		//repo.deleteById(1);
		
	}

}

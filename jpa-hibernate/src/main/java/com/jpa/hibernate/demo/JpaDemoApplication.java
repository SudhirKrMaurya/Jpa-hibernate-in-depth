package com.jpa.hibernate.demo;
import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.demo.entity.Employee;
import com.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.jpa.hibernate.demo.entity.PartTimeEmployee;
import com.jpa.hibernate.demo.repo.CourseRepo;
import com.jpa.hibernate.demo.repo.EmployeeRepo;
import com.jpa.hibernate.demo.repo.ReviewRepo;
import com.jpa.hibernate.demo.repo.StudentRepo;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{
	@Autowired
	 CourseRepo repo;
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	ReviewRepo reviewrepo;
	@Autowired
	EmployeeRepo employeeRepo;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}
	@Override
	public void run(String... args0) throws Exception {
		/*
		 * // TODO Auto-generated method stub
		 * logger.info("find by id-->{}",repo.findById(3));
		 * logger.info("insert info in db-->{}",repo.insert(new
		 * Course("nitu","ranjeetneetu@gamil.com","gurugaon","8520852369")));
		 * repo.deleteById(1);
		 */
		//logger.info("find by id Student-->{}",studentRepo.findById(8));
		System.err.println("student-->"+studentRepo.addStudentAddress(12));
	   // studentRepo.studentWithpassport();
		//logger.info("rating find by id ====================-->{}",reviewrepo.reviewById(2));
		//repo.addReviewForCourse(2);
		/*
		 * List<Rating> rating=new ArrayList<>(); rating.add(new Rating(4,"good"));
		 * rating.add(new Rating(5,"good"));
		 */
		//repo.addHardCodedReviewForCourse(4, rating);
        //studentRepo.insertStudentInfo();
//        studentRepo.findStudentByName("Mr.Ranjeet Gaitondende");
		employeeRepo.insert(new FullTimeEmployee("Gaitonde",new BigDecimal(1000)));
		employeeRepo.insert(new PartTimeEmployee("Sonu",new BigDecimal(5000))) ;
       	}
	

}

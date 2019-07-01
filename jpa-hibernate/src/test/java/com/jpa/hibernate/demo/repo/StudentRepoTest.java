package com.jpa.hibernate.demo.repo;
import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import com.jpa.hibernate.demo.repo.StudentRepo;
import com.jpa.hibernate.demo.JpaDemoApplication;
import com.jpa.hibernate.demo.entity.Address;
import com.jpa.hibernate.demo.entity.Student;
import com.jpa.hibernate.demo.entity.passport;
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = JpaDemoApplication.class)
public class StudentRepoTest {
//private Logger logger = LoggerFactory.getLogger(this.getClass()); 

@Autowired
StudentRepo studentRepoTest;
@Autowired
EntityManager em;

@Test
@Transactional
public void setStudentAddress() {
	Student student =studentRepoTest.findById(12);
	System.err.println("test Student=="+student);
	//Student student= em.find(Student.class,40);
	student.setAddress(new Address("line1", "line 2", "City"));
	em.flush();
	
}

@Test
@DirtiesContext
	
	  public void retriveDetailsAndPassport() { 
	Student
	  student=studentRepoTest.findById(12);
	  System.err.println("Student Test"+student.getPassport().getPassportNo());
	  assertEquals("sudhir",student.getName()); assertEquals("IND0021165",student.getPassport().getPassportNo());
	  //assertEquals("18",student.getPassport().getId());
	  
	  }
	 
@Test
@Transactional
public void functionForTransactionalVerify() {
	Student student=studentRepoTest.findById(12);
	System.err.println("roll back");
	passport passport=student.getPassport();
	passport.setPassportNo("IND9211420");
	student.setName("Ranjeet");
}
@Test
@Transactional
public void getCourseAndStudent() {
	Student student =studentRepoTest.findById(2);
	System.err.println("Student name==>"+student.getName());
	System.err.println("Student Course retriew==>"+student.getCourses().toString());
}

@Test
@Transactional
public void getStudentInfo() {
	Student student=studentRepoTest.findById(2); 
	
	System.err.println("Student info==>"+student.getName());
	System.err.println("Student'course Info==>"+student.getCourses().get(0).getName());

}

}

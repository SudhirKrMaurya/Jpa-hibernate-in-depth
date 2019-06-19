package com.jpa.hibernate.demo.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
@Entity
public class Student{
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@ManyToMany(mappedBy = "student",fetch = FetchType.EAGER) 
	private List<Course> courses=new ArrayList<>();
	
	@OneToOne(fetch = FetchType.LAZY)
	private passport passport;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public passport getPassport() {
		return passport;
	}
	public void setPassport(passport passport) {
		this.passport = passport;
	}
	
	public Student(String name) {
		this.name = name;
	}
	public Student() {
		
	}
	
	  public Student(Integer id, String name) { 
		  super();
		  this.id = id;
		  this.name =
	  name; }
	
	public List<Course> getCourses() {
		return courses;
	}
	public void addCourses(Course courses) {
		this.courses.add(courses);
	}
	
	
	
	
	
	
	
  

}

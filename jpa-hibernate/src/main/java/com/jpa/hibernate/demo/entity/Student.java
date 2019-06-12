package com.jpa.hibernate.demo.entity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Student{
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
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
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
  

}

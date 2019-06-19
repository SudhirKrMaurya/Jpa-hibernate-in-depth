package com.jpa.hibernate.demo.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(value=
{
	@NamedQuery(name="query_get_all_courses",query="select c from Course c"),
	@NamedQuery(name="query_get_courses",query="select c from Course c where name='ranjeet'")
		}
		)


public class Course {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String email;
	private String address;
	private String contact;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="course_student",joinColumns= @JoinColumn(name="course_id")
	,inverseJoinColumns = @JoinColumn(name="student_id"))
	private List<Student> student=new ArrayList<>(); 
	
	@OneToMany(mappedBy = "course")
    private List<Rating> rating =new ArrayList<Rating>();
    
	public String getEmail() {
		return email;
	}
	public Course(String name, String email, String address, String contact) {
		super();
		this.name = name; 
		this.email = email;
		this.address = address;
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getContatct() {
		return contact;
	}

	public void setContatct(String contatct) {
		this.contact = contatct;
	}

	protected Course() //other class not be used
	{
		
	}
	
	public Course(String name) {
		this.name=name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Rating> getRating() {
		return rating;
	}
	public void addRating(Rating rating) {
		this.rating.add(rating);
	}
	public void removeRating(Rating rating) {
		this.rating.remove(rating);
	}
	public List<Student> getStudent() {
		return student;
	}
	public void addStudent(Student student) {
		this.student.add(student);
	}
	
	

}

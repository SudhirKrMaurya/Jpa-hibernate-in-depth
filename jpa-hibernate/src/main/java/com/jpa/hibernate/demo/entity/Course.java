 package com.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@NamedQueries(value=
{
	@NamedQuery(name="query_get_all_courses",query="select c from Course c"),
	@NamedQuery(name="query_get_courses",query="select c from Course c where name='ranjeet'")
		}
		)


public class Course {
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", contact="
				+contact + "]";
	}
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String email;
	private String address;
	private String contact;
	
	
	
	
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

}

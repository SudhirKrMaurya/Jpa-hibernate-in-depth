package com.jpa.hibernate.demo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class passport{
	@Id
	@GeneratedValue
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String passportNo;
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public passport() {
		
	}
	
	 public passport(String passportNo) {
		 this.passportNo=passportNo;
	 }
	

}

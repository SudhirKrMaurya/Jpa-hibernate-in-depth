package com.jpa.hibernate.demo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class passport{
	@Id
	@GeneratedValue
	private Integer id;
	private String passportNo;
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	@Override
	public String toString() {
		return "passport [id=" + id + ", passportNo=" + passportNo + "]";
	}
	
	

}

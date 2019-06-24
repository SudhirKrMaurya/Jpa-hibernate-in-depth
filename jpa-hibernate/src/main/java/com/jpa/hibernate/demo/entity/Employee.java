package com.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  //default method store and all entity mapped in single table
@DiscriminatorColumn(name="employee_type")
public abstract class Employee {
@Id
@GeneratedValue
private Integer id;
@Column(nullable = false)
private String name;

public Employee() {
	
}
public Employee(String name) {
	this.name=name;
}
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
}

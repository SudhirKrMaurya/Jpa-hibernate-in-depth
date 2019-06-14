package com.jpa.hibernate.demo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "review")

public class Rating{
	@Id
	@GeneratedValue
	private Integer id;
	private int rating;
	private String description;
	 
	@ManyToOne            // many to one relation b/w course and rating
	private Course course;
	 Rating() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", description=" + description + ", course=" + course + "]";
	}
	
	
}

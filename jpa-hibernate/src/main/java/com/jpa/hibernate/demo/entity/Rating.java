package com.jpa.hibernate.demo.entity;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
	@Enumerated
	private Review rating;
	/**
	 * @return the rating
	 */
	public Review getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(Review rating) {
		this.rating = rating;
	}
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
	
	public Rating(Review rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", description=" + description + ", course=" + course + "]";
	}
	
	
}

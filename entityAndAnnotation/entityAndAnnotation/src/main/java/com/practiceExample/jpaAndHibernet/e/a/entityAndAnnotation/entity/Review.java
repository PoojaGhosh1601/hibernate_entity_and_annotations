package com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private long id;
	
	@Enumerated(EnumType.STRING)
	private ReviewRating rating;
		
	private String description;
	
	@ManyToOne
	private Course course;
	
	private Review() {
		
	}

	public Review(ReviewRating rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}

	public ReviewRating getRating() {
		return rating;
	}

	public void setRating(ReviewRating rating) {
		this.rating = rating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescriptionr(String description) {
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
		return "Review [rating=" + rating + ", description=" + description + "]";
	}

	
	
	

}

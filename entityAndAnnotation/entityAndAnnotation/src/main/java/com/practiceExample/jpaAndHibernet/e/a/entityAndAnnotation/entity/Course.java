package com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries(value = { @NamedQuery(name = "find_all_course", query = "Select c from Course c"),
		@NamedQuery(name = "find_all_course_with_name", query = "Select c from Course c where name like '%JPA'") }

)

@Cacheable
@SQLDelete(sql = "update course set is_deleted=true where id=?")
@Where(clause="is_deleted = false")
public class Course {
	@Id
	@GeneratedValue
	private long id;

	private String name;

	@OneToMany(mappedBy="course")
	//@JsonIgnore
	private List<Review> reviews = new ArrayList<Review>();
	
	@ManyToMany(mappedBy="courses")
	@JsonIgnore
	private List<Student> students = new ArrayList<Student>();
	
	private static Logger logger = LoggerFactory.getLogger(Course.class);

	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student students) {
		this.students.add(students);
	}
	
	private boolean isDeleted;
	
	@PreRemove
	private void preRemoved() {
		logger.info("setting isDeleted to true");
		this.isDeleted =  true;
	}

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;

	private Course() {

	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review reviews) {
		this.reviews.add(reviews);
	}
	
	public void removeReviews(Review reviews) {
		this.reviews.remove(reviews);
	}

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}

}

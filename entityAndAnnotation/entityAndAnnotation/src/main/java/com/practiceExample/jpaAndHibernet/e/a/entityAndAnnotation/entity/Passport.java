package com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Passport {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String number;
	
	@OneToOne(mappedBy="passport")
	//@OneToOne
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private Passport() {
		
	}

	public Passport(String number) {
		super();
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Passport[number=" + number + "]";
	}
	
	
	

}

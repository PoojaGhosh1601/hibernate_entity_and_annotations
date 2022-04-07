package com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class PartTimeEmployee extends Employee {

	private BigDecimal hourlyWage;

	public PartTimeEmployee(String name) {
		super(name);
	}

	public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	@Override
	public String toString() {
		return "PartTimeEmployee [name=" + hourlyWage + "]";
	}

}

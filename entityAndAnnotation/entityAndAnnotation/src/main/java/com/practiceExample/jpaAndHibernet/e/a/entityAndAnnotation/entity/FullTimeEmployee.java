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
public class FullTimeEmployee extends Employee {

	private BigDecimal salary;

	public FullTimeEmployee(String name) {
		super(name);
	}

	public FullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "PartTimeEmployee [name=" + salary + "]";
	}

}

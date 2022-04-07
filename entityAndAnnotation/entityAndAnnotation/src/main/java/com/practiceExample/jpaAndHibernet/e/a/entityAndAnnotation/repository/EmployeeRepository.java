package com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Course;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Employee;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.FullTimeEmployee;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.PartTimeEmployee;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Review;

@Repository
public class EmployeeRepository {

	@Autowired
	EntityManager em;

	//Insert an employee
	
	public void insert(Employee employee) {
		em.persist(employee);
		
	}
	//delete an employee
	public List<Employee> retriveAllEmployees() {
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}
	
	public List<PartTimeEmployee> retriveAllPartTimeEmployees() {
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	
	public List<FullTimeEmployee> retriveAllFullTimeEmployees() {
		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}
	

}

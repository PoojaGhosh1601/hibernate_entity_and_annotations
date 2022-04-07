package com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Course;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Student;

@Repository
public class JPQLWithRelationship {
	@Autowired
	EntityManager em;
	
	public List<Course> coursesWithoutStudent() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
		List<Course> resultList = query.getResultList();
		return resultList;
	}
	
	public List<Course> coursesAtLeast2Student() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
		List<Course> resultList = query.getResultList();
		return resultList;
	}
	
	public List<Course> coursesAtLeast2StudentOrderBy() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students)", Course.class);
		List<Course> resultList = query.getResultList();
		return resultList;
	}
	
	public List<Course> coursesAtLeast2StudentOrderByDESC() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
		List<Course> resultList = query.getResultList();
		return resultList;
	}
	
	public List<Student> studentWithPassportInAPattern() {
		TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%1234%'", Student.class);
		List<Student> resultList = query.getResultList();
		return resultList;
	}
	
	public List<Object[]> join() {
		Query query = em.createQuery("Select c, s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		return resultList;
	}
	
	public List<Object[]> leftJoin() {
		Query query = em.createQuery("Select c, s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		return resultList;
	}
	
	public List<Object[]> crossJoin() {
		Query query = em.createQuery("Select c, s from Course c, Student s");
		List<Object[]> resultList = query.getResultList();
		return resultList;
	}

}

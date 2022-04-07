package com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository;

import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Course;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Student;

@Repository
public class CriteriaQueries {
	@Autowired
	EntityManager em;

	public List<Course> selectCourse() {

		// "Select c from Course c"

		// 1.use criteria builder to create a criteria query returning the expected
		// result

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2.Define roots for the tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3.Define predicates etc using criteria builder

		// 4.Add predicates etc to the criteria query

		// 5.Build the TypedQuery using the entity manager and criteria query

		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		return resultList;
	}

	public List<Course> selectCourseUsingWhere() {
		// "Select c from Course c where name like'%PA'"

		// 1.use criteria builder to create a criteria query returning the expected
		// result

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2.Define roots for the tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3.Define predicates etc using criteria builder
		
		//Predicate like = cb.le(courseRoot.get("name"), "pa%");
		

		// 4.Add predicates etc to the criteria query
		//cq.where(like);

		// 5.Build the TypedQuery using the entity manager and criteria query

		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		return resultList;
	}
	
	public List<Course> selectAllCourseWithoutStudents() {
		// "Select c from Course c where c.students is empty"

		// 1.use criteria builder to create a criteria query returning the expected
		// result

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2.Define roots for the tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3.Define predicates etc using criteria builder
		
		 //Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
		

		// 4.Add predicates etc to the criteria query
		//cq.where(studentsIsEmpty);

		// 5.Build the TypedQuery using the entity manager and criteria query

		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		return resultList;
	}
	
	public List<Course> join() {
		// "Select c from Course c join c.students"

		// 1.use criteria builder to create a criteria query returning the expected
		// result

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2.Define roots for the tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3.Define predicates etc using criteria builder
		Join<Object, Object> join = courseRoot.join("students");	

		// 4.Add predicates etc to the criteria query

		// 5.Build the TypedQuery using the entity manager and criteria query

		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		return resultList;
	}
	
	public List<Course> leftJoin() {
		// "Select c from Course c join c.students"

		// 1.use criteria builder to create a criteria query returning the expected
		// result

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2.Define roots for the tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3.Define predicates etc using criteria builder
		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);	

		// 4.Add predicates etc to the criteria query

		// 5.Build the TypedQuery using the entity manager and criteria query

		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		return resultList;
	}


}

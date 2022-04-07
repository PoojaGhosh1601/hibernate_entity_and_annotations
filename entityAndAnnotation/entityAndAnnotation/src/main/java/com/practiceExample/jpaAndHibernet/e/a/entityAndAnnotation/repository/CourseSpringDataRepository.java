package com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Course;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
	List<Course> findByNameAndId(String name, Long id);
//
	List<Course> findByName(String name);
//
//	List<Course> countByName(String name);
//
//	List<Course> findByNameOrderByDesc(String name);
//
	List<Course> deleteByName(String name);

	@Query("Select c from Course c where name like '%JPA' ")
	List<Course> courseWithSpecificNameMatching();

	@Query(value = "Select * From Course c where name like '%JPA' ", nativeQuery = true)
	List<Course> courseUsingNativeQuery();

	@Query(name = "find_all_course_with_name")
	List<Course> courseUsingNamedCourse();

}

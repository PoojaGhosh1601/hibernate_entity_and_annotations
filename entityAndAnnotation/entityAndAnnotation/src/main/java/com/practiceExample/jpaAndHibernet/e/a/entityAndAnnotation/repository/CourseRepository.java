package com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Course;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Review;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.ReviewRating;

@Repository
public class CourseRepository {

	@Autowired
	EntityManager em;

	// public Course findById(Long id);
	// public Course save(Course course);
	// public void deleteById(Long id);

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}

	public Course save(Course course) {
		if (course.getId() == 0L) {
			// Insert
			em.persist(course);

		} else {
			// Update
			em.merge(course);
		}
		return course;
	}
	// finedAll using JPQL

	public List<Course> findAll() {
		TypedQuery<Course> namedQuery = em.createNamedQuery("find_all_course", Course.class);
		return namedQuery.getResultList();
	}

	public void modifyCourse() {
		Course course1 = new Course("Spring Mono");
		em.persist(course1);

		Course course2 = findById(10001L);
		course2.setName("JPA- updated");
	}

	public List<Course> getSpecificCourse() {
		TypedQuery<Course> namedQuery = em.createNamedQuery("find_all_course_with_name", Course.class);
		return namedQuery.getResultList();
	}

	public List<Course> nativeQueryPositionParam() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE where id = ?", Course.class);
		query.setParameter(1, 10001L);
		return query.getResultList();
	}

	public List<Course> nativeQueryNamedParam() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE where id = :id", Course.class);
		query.setParameter("id", 10003L);
		return query.getResultList();
	}

	public void addReviewsForCourse() {
		// get the course
		Course course = findById(10003L);

		// adding reviews
		Review review1 = new Review(ReviewRating.FIVE, "Great hands-On stuff");
		Review review2 = new Review(ReviewRating.FIVE, "Hatsoff");

		// setting the relationship
		course.addReviews(review1);
		review1.setCourse(course);

		course.addReviews(review2);
		review2.setCourse(course);

		// saving to database
		em.persist(review1);
		em.persist(review2);

	}

	public void addReviewsForCourse(Long courseId, List<Review> reviews) {

		Course course = findById(courseId);

		for (Review review : reviews) {
			course.addReviews(review);
			review.setCourse(course);
			em.persist(review);
		}

	}

	public List<Review> retriveReviewsForCourse() {
		Course course = findById(10001L);
		List<Review> reviews = course.getReviews();
		return reviews;

	}

}

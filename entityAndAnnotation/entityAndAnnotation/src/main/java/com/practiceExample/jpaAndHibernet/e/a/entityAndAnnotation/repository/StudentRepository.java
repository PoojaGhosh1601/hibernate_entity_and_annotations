package com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Address;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Course;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Passport;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager em;

	// public Student findById(Long id);
	// public Student save(Student student);
	// public void deleteById(Long id);

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	//
	// public void deleteById(Long id) {
	// Student student = findById(id);
	// em.remove(student);
	// }
	//
	// public Student save(Student student) {
	// if(student.getId() == 0L) {
	// //Insert
	// em.persist(student);
	//
	// } else {
	// //Update
	// em.merge(student);
	// }
	// return student;
	// }
	// finedAll using JPQL

	public void saveStudentWithPassport() {
		Passport passport = new Passport("P1234567");
		em.persist(passport);
		Student student = new Student("Mike");
		student.setPassport(passport);
		em.persist(student);
	}
	
	public void saveCourseForStudent() {
		Student student = new Student("Prince");
		Course course = new Course("Spring Mono");
		em.persist(student);
		em.persist(course);
		
		student.addCourses(course);
		course.addStudents(student);
		
		em.persist(student);
	}

	// public void modifyStudent() {
	// Student student1 = new Student("Spring Mono");
	// em.persist(student1);
	//
	// Student student2 = findById(10001L);
	// student2.setName("JPA- updated");
	// }

	public Passport retriveStudentAndPassport(Long id) {

		Student student = findById(id);
		Passport passport = student.getPassport();
		return passport;

	}
	
	public void addAddress() {
		Student student = findById(20001L);
		student.setAddress(new Address("No 101", "T Centrln", "Stockholm"));
		em.persist(student);
	}

}

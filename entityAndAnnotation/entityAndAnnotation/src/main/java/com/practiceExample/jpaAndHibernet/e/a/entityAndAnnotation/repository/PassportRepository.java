package com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Passport;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Student;

@Repository
@Transactional
public class PassportRepository {

	@Autowired
	EntityManager em;

	// public Student findById(Long id);
	// public Student save(Student student);
	// public void deleteById(Long id);

	public Passport findById(Long id) {
		return em.find(Passport.class, id);
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

	public void savePassportWithStudent() {
		Student student = new Student("Pramit");
		em.persist(student);
		
		Passport passport = new Passport("S1234567");
		passport.setStudent(student);
		em.persist(passport);
	}

	// public void modifyStudent() {
	// Student student1 = new Student("Spring Mono");
	// em.persist(student1);
	//
	// Student student2 = findById(10001L);
	// student2.setName("JPA- updated");
	// }

	public Student retrivePassportAndStudent(Long id) {

		
		Passport passport= findById(id);
		Student student = passport.getStudent();
		return student;

	}

}

package com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.h2.mvstore.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Course;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.FullTimeEmployee;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.PartTimeEmployee;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository.CourseRepository;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository.CourseSpringDataRepository;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository.CriteriaQueries;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository.EmployeeRepository;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository.JPQLWithRelationship;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository.PassportRepository;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository.ReviewRepository;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository.StudentRepository;

@SpringBootApplication
@Transactional
public class EntityAndAnnotationApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	PassportRepository passportRepo;
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	ReviewRepository reviewRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	
	@Autowired
	JPQLWithRelationship jpqlRepo;
	
	@Autowired
	CriteriaQueries criteriaRepo;
	
	@Autowired
	CourseSpringDataRepository springDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(EntityAndAnnotationApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
//		Course course = repository.findById(10001L);
//		logger.info("course 10001 is {}",course);
//		
//		//repository.deleteById(10001L);
//		//repository.save(new Course("Microservices"));
//		
//		logger.info("\n All Course -> {}", repository.findAll());
//		logger.info("\n All JPA Courses -> {}", repository.getSpecificCourse());
//		logger.info("\n Courses of id 10001 -> {}", repository.nativeQueryPositionParam());
//		logger.info("\n Courses of id 10003 -> {}", repository.nativeQueryNamedParam());
//		
//		repository.modifyCourse();
		
		
//		studentRepo.saveStudentWithPassport();
//		logger.info("\n Student id 20001L passport information -> {}", studentRepo.retriveStudentAndPassport(20001L));
//		
//		
//		passportRepo.savePassportWithStudent();
//		logger.info("\n Passport no L236546 associated student information -> {}", passportRepo.retrivePassportAndStudent(40003L));
//		
//		courseRepo.addReviewsForCourse();
//		logger.info("\n Review for the course JPA -> {}", courseRepo.retriveReviewsForCourse());
//		//logger.info("\n Course for the Review 50001 -> {}", reviewRepo.retriveCourseForReview());
//		studentRepo.saveCourseForStudent();
//		
//		employeeRepo.insert(new FullTimeEmployee("jack", new BigDecimal(10000)));
//		employeeRepo.insert(new PartTimeEmployee("Rayan", new BigDecimal(50	)));
//		
//		//logger.info("\n Review all employees -> {}", employeeRepo.retriveAllEmployees());
//		logger.info("\n Review all employees -> {}", employeeRepo.retriveAllFullTimeEmployees());
//		logger.info("\n Review all employees -> {}", employeeRepo.retriveAllPartTimeEmployees());
//		
		
//		logger.info("\n Courses without student -> {}", jpqlRepo.coursesWithoutStudent());
//		logger.info("\n Courses At least 2 student -> {}", jpqlRepo.coursesAtLeast2Student());
//		logger.info("\n Courses order by student -> {}", jpqlRepo.coursesAtLeast2StudentOrderBy());
//		logger.info("\n Courses order by student -> {}", jpqlRepo.coursesAtLeast2StudentOrderByDESC());
//		logger.info("\n Student With Passport no like 1234 -> {}", jpqlRepo.studentWithPassportInAPattern());
//		logger.info("\n Result size of join {}", jpqlRepo.join().size());
//		logger.info("\n Result size of left join {}", jpqlRepo.leftJoin().size());
//		logger.info("\n Result size of cross join {}", jpqlRepo.crossJoin().size());
//		
//		List<Object[]> resultList = jpqlRepo.join();
//		for(Object[] result:resultList) {
//			logger.info("\n Course{} student{}", result[0], result[1]);			
//		}
		
		
//		logger.info("\n Select Course using criteria queries -> {}", criteriaRepo.selectCourse());
//		logger.info("\n Select Course using criteria queries Join -> {}", criteriaRepo.join());
//		logger.info("\n Select Course using criteria queries left join -> {}", criteriaRepo.leftJoin());
		
		
//		Optional<Course> courseOptional = springDataRepository.findById(10001L);
//		//Sort sort = new Sort(Sort.Direction.DESC, "name");
//		logger.info("\n Course Optional -> {}", courseOptional.get());
//		
//		Course course = new Course("Microservices");
//		springDataRepository.save(course);
//		course.setName("Microservices-updated");
//		springDataRepository.save(course);
//		
//		logger.info("\n Courses -> {}", springDataRepository.findAll());
//		
//		
//		//pagination
//		
//		PageRequest pageRequest = PageRequest.of(0, 3);
//		org.springframework.data.domain.Page<Course> firstPage = springDataRepository.findAll(pageRequest);
//		logger.info("\n First Page -> {}",firstPage.getContent());
//		
//		Pageable nextPageable = firstPage.nextPageable();
//		org.springframework.data.domain.Page<Course> secondPage = springDataRepository.findAll(nextPageable);
//		logger.info("\n Second Page -> {}",secondPage.getContent());
		
//		logger.info("\n courseWithSpecificNameMatching -> {}", springDataRepository.courseWithSpecificNameMatching());
//		logger.info("\n courseUsingNativeQuery -> {}", springDataRepository.courseUsingNativeQuery());
//		logger.info("\n courseUsingNamedCourse -> {}", springDataRepository.courseUsingNamedCourse());
		
//		courseRepo.deleteById(10005L);
//		Course course = courseRepo.findById(10005L);
//		logger.info("\n course that is deleted is -> {}", course);
		
		//studentRepo.addAddress();
		logger.info("\n address is embadded -> {}");
	}
	

}

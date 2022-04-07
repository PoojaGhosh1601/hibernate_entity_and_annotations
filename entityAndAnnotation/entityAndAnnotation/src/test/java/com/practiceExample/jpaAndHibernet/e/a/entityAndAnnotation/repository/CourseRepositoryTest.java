package com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.repository;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.EntityAndAnnotationApplication;
import com.practiceExample.jpaAndHibernet.e.a.entityAndAnnotation.entity.Course;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes= {EntityAndAnnotationApplication.class})
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations= {"classpath:test-configuration.properties"})
public class CourseRepositoryTest {
//	@Autowired
//	CourseRepository repository;
//	
//	@Test
//	public void findById_basic() {
//		Course course = repository.findById(10002L);
//		assertEquals("Hibernet",course.getName());
//	}


}

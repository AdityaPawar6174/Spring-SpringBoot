package com.aditya.SpringJPA;

import com.aditya.SpringJPA.model.Student;
import com.aditya.SpringJPA.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);

		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		s1.setName("AAA");
		s1.setMarks(56);
		s1.setRollNo(1);

		s2.setName("BBB");
		s2.setMarks(75);
		s2.setRollNo(2);

		s3.setName("CCC");
		s3.setMarks(87);
		s3.setRollNo(3);

		repo.findByName("BBB");
	}

}

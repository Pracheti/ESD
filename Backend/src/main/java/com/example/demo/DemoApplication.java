package com.example.demo;

import com.example.demo.Entities.Students;
import com.example.demo.Repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		Students student = new Students();
		student.setStudent_id(1);
		student.setEmail("bhale@gmail.com");
		student.setCgpa(8.7f);
		student.setDomain("ML");
		student.setFirst_name("Prach");
		student.setLast_name("Bhale");
		student.setGraduation_year(2019);
		student.setPhotograph_path("pictures");
		student.setSpecialisation("ML");
		student.setTotal_credits(10);
		studentRepository.save(student);
	}
}

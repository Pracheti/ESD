package com.example.demo;

import com.example.demo.Entities.Students;
import com.example.demo.Repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		Students s1 = studentRepository.getStudentsByStudent_id(1);
		if(s1!=null)
			System.out.println(s1.getFirst_name());
		else
			System.out.println("Null");
	}
}

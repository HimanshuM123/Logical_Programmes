package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.StudentService;



@SpringBootApplication
public class SampleSpringBootApplication {
	@Autowired
	 private static  StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringBootApplication.class, args);
		
	}

}

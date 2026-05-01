package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.Student;
import com.example.demo.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Cacheable("StudentCache")
  public Student getName(int num) {

    return (Student) studentRepository.findById(2L);
       
  }
}
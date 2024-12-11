package com.example.rest.controller;

import java.util.List;
//Importing required classes
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.rest.component.ComponentTest;
import com.example.rest.entity.Department;
import com.example.rest.service.DepartmentService;

//Annotation
@RestController

//Class
public class DepartmentController {

 @Autowired private DepartmentService departmentService;
 
 @Autowired
 private ComponentTest componentTest;



 // Read operation
 @GetMapping("/counterEx")
 public void fetchDepartmentList()
 {
	
     int counter= componentTest.getCounter();
     System.out.println("Printing counter "+counter);
 }

 
}
package com.example.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.entity.Department;

// Annotation
@Repository

// Interface extending CrudRepository
public interface DepartmentRepository
    extends CrudRepository<Department, Long> {
}
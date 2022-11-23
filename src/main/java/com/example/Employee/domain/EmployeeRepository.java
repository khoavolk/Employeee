package com.example.Employee.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	 List<Employee> findByTitle(String title);
	 List<Employee> findByAuthor(String author);
	 
	    
	
}
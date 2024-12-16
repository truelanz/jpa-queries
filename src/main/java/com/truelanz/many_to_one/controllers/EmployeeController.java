package com.truelanz.many_to_one.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truelanz.many_to_one.entities.Employee;
import com.truelanz.many_to_one.repositories.EmployeeRepository;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//Buscar todos
	/* @GetMapping
	public List<Employee> findAll() {
		return employeeRepository.searchAll();
	} */

	//Busca Paginada
	@GetMapping
	public Page<Employee> findAll(Pageable pageable) {
		return employeeRepository.searchAllPageable(pageable);
	}
}

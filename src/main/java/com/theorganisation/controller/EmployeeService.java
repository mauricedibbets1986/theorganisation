package com.theorganisation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theorganisation.domain.*;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeerepository;
	
	public Employee addEmployee(Employee employee) {
		System.out.println("Employee toegevoegd aan database");
		return employeerepository.save(employee);
	}

	public Iterable<Employee> getAllEmployees() {
		System.out.println("inzien alle employees in database");
		return employeerepository.findAll();
	}
	
}

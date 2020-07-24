package com.theorganisation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theorganisation.controller.*;
import com.theorganisation.domain.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeEndpoint {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/new")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/all")
	public Iterable<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}

	@PutMapping("/id/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") long id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(employee, id);
	}
	
	@PutMapping("/telefoon/{employeeId}/{telefoonId}")
	public Employee updateEmployeeTelefoon(@PathVariable(value = "employeeId") long employeeId, 
	@PathVariable(value = "telefoonId") long telefoonId) {
		return employeeService.updateEmployeeTelefoon(employeeId, telefoonId);
	}
	
	@DeleteMapping("/id/{id}")
	public void deleteEmployee(@PathVariable(value = "id") long employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
	
}

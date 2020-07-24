package com.theorganisation.rest;

import java.util.List;

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
import com.theorganisation.domain.Department;

@RestController
@RequestMapping("/api/department")
public class DepartmentEndpoint {

	@Autowired
	DepartmentService departmentservice;
	
	@PostMapping("/new")
	public Department addDepartment(@RequestBody Department department) {
		return departmentservice.addDepartment(department);
	}
	
	@GetMapping("/all")
	public Iterable<Department> getDepartments() {
		return departmentservice.getAllDepartments();
	}
	
	@GetMapping("/id/{id}")
	public Department getDepartmentById(@PathVariable(value = "id") long id) {
		return departmentservice.getById(id);
	}
	
	@GetMapping("/name/{name}")
	public List<Department> getDepartmentByName(@PathVariable(value = "name") String name) {
		return departmentservice.getByName(name);
	}
	
	@DeleteMapping("/id/{id}")
	public void deleteDepartment(@PathVariable(value = "id") long id) {
		departmentservice.deleteDepartmentById(id);
	}
	
	@PutMapping("/id/{id}")
	public Department updateDepartment(@PathVariable(value = "id") long id, @RequestBody Department departmentdetails) {
		return departmentservice.updateDepartment(id, departmentdetails);
	}
	
	@PutMapping("/addemployee/{departmentid}/{employeeid}")
	public Department addEmployeeToDepartment(@PathVariable(value = "departmentid") long departmentid, @PathVariable(value = "employeeid") long employeeid) {
		return departmentservice.addEmployee(departmentid, employeeid);
	}
	
}

package com.theorganisation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theorganisation.domain.*;

@Service
@Transactional
public class DepartmentService {
	
	@Autowired
	DepartmentRepository<Department> departmentrepository;
	@Autowired
	EmployeeRepository<Employee> employeerepository;
	
	public Department addDepartment(Department department) {
		System.out.println("department toegevoegd aan database");
		return departmentrepository.save(department);
	}

	public Iterable<Department> getAllDepartments() {
		System.out.println("inzien alle departments in database");
		return departmentrepository.findAll();
	}

	public Department getById(long id) {
		System.out.println("inzien department gevonden met id");
		return departmentrepository.findById(id).get();
	}

	public List<Department> getByName(String name) {
		System.out.println("Inzien department gevonden met name");
		return departmentrepository.findByName(name);
	}

	public void deleteDepartmentById(long id) {
		System.out.println("Department verwijderd dmv id");
		departmentrepository.deleteById(id);
	}

	public Department updateDepartment(long id, Department departmentdetails) {
		Department department = departmentrepository.findById(id).get();
		if (departmentdetails.getName() != null && departmentdetails.getName() != "") {
			department.setName(departmentdetails.getName());
		}
		System.out.println("Department gevonden met id en aangepast");
		return departmentrepository.save(department);
	}

	public Department addEmployee(long departmentid, long employeeid) {
		Department department  = departmentrepository.findById(departmentid).get();
		Employee employee = employeerepository.findById(employeeid).get();
		department.addEmployees(employee);
		System.out.println("employee added to department in database");
		return departmentrepository.save(department);
	}
	
}

package com.theorganisation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theorganisation.domain.*;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	EmployeeRepository<Employee> employeerepository;
	@Autowired
	TelefoonRepository<Telefoon> telefoonrepository;
	
	public Employee addEmployee(Employee employee) {
		System.out.println("Employee toegevoegd aan database");
		return employeerepository.save(employee);
	}

	public Iterable<Employee> getAllEmployees() {
		System.out.println("inzien alle employees in database");
		return employeerepository.findAll();
	}

	public void addMessageToEmployee(Employee employee, Message theMessage) {
		System.out.println("message added to employee");
		employee.addMessage(theMessage);
		employeerepository.save(employee);
	}

	public Employee updateEmployeeTelefoon(long employeeId, long telefoonId) {
		Employee thisEmployee = employeerepository.findById(employeeId).get();
		thisEmployee.setTelefoon(telefoonrepository.findById(telefoonId).get());
		return null;
	}

		
	public Employee updateEmployee(Employee employeedetails, long id) {
		System.out.println("employee updated");
		Employee employee = employeerepository.findById(id).get();
		if (employeedetails.getName()!= null && employeedetails.getName() != "") {
			employee.setName(employeedetails.getName());
		}
		if (employeedetails.getSalary()!= 0) {
			employee.setSalary(employeedetails.getSalary());
		}
		
		return employeerepository.save(employee);
	}

	public void deleteEmployee(long employeeId) {
		System.out.println("Employee deleted from Database");
		employeerepository.deleteById(employeeId);;
	}
	
	
}

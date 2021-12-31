package com.balu.gl.employee.management.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.balu.gl.employee.management.employeemanagement.entity.Employee;
import com.balu.gl.employee.management.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@GetMapping("/list")
	public List<Employee> getAllEmployee() {
		return employeeService.findAll();
	}

	@GetMapping("/employeeById/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		Optional<Employee> emp = employeeService.findById(id);
		return emp.get();
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.addOrUpdateEmployee(employee);
	}

	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addOrUpdateEmployee(employee);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteByEmployeeId(@PathVariable Long id) {
		try {
			if (null != id) {
				employeeService.deleteEmployee(id);
				return "Deleted Employee id - " + id;
			} else {
				return "Employee can not be deleted since passed in Id is null";
			}
		} catch (Exception e) {
			return "Exception while deleting the employee id - " + id;
		}
	}

	@GetMapping("/search/{firstName}")
	public List<Employee> searchByFirstName(@PathVariable String firstName) {
		return employeeService.findByFirstName(firstName);
	}

	@GetMapping("/sort")
	public List<Employee> sortByFirstName(@RequestParam String order) {
		return employeeService.findAndSortByFirstName(order);
	}

}

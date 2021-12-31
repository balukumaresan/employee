package com.balu.gl.employee.management.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.balu.gl.employee.management.employeemanagement.entity.Employee;

@Service
public interface EmployeeService {

	public List<Employee> findAll();

	public Employee addOrUpdateEmployee(Employee employee);

	public Optional<Employee> findById(Long id);

	public void deleteEmployee(Long id);

	public List<Employee> findByFirstName(String firstName);

	public List<Employee> findAndSortByFirstName(String order);
}

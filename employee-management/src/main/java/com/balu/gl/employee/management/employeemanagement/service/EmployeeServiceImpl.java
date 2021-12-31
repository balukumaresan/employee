package com.balu.gl.employee.management.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.balu.gl.employee.management.employeemanagement.dao.EmployeeRepository;
import com.balu.gl.employee.management.employeemanagement.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee addOrUpdateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}

	public void deleteEmployee(Long id) {

		employeeRepository.deleteById(id);
	}

	public List<Employee> findByFirstName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

	public List<Employee> findAndSortByFirstName(String order) {

		if ("asc".equals(order)) {
			return employeeRepository.findAll(Sort.by("firstName").ascending());
		} else if ("desc".equals(order)) {
			return employeeRepository.findAll(Sort.by("firstName").descending());
		}
		return employeeRepository.findAll(Sort.by("firstName"));
	}
}

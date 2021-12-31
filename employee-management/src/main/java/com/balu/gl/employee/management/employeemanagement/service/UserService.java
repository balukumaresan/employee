package com.balu.gl.employee.management.employeemanagement.service;

import org.springframework.stereotype.Service;

import com.balu.gl.employee.management.employeemanagement.entity.User;

@Service
public interface UserService {

	public User addUser(User user);
}

package com.balu.gl.employee.management.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balu.gl.employee.management.employeemanagement.dao.UserRepository;
import com.balu.gl.employee.management.employeemanagement.entity.User;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

}

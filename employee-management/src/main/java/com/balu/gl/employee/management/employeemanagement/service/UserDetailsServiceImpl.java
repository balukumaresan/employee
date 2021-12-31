package com.balu.gl.employee.management.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.balu.gl.employee.management.employeemanagement.configuration.MyUserDetails;
import com.balu.gl.employee.management.employeemanagement.dao.UserRepository;
import com.balu.gl.employee.management.employeemanagement.entity.User;


public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUserName(username);
		
		if(user == null)
		{
			throw new UsernameNotFoundException("Sorry User Not found");
		}
		return new MyUserDetails(user);
		
	}

}

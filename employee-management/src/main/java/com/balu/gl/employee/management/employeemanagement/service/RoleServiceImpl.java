package com.balu.gl.employee.management.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balu.gl.employee.management.employeemanagement.dao.RoleRepository;
import com.balu.gl.employee.management.employeemanagement.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

}

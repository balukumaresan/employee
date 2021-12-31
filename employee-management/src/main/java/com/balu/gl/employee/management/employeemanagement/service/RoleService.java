package com.balu.gl.employee.management.employeemanagement.service;

import org.springframework.stereotype.Service;

import com.balu.gl.employee.management.employeemanagement.entity.Role;

@Service
public interface RoleService {

	public Role addRole(Role role);
}

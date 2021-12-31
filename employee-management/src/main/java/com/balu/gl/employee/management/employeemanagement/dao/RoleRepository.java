package com.balu.gl.employee.management.employeemanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balu.gl.employee.management.employeemanagement.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}

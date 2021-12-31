package com.balu.gl.employee.management.employeemanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.balu.gl.employee.management.employeemanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.userName = ?1")
	public User getUserByUserName(String userName);
}

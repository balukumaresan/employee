package com.balu.gl.employee.management.employeemanagement.entity;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoles {

	@Column(name = "user_id")
	private long userId;
	@Column(name = "role_id")
	private long roleId;
}

package com.balu.gl.employee.management.employeemanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.balu.gl.employee.management.employeemanagement.service.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/api/employees/list", "/api/employees/update", "/api/employees/delete",
						"/api/employees/sort", "/api/employees/search/", "/api/employees/employeeById/")
				.hasAnyAuthority("USER", "ADMIN").antMatchers("/api/employees/add", "/api/employees/delete/")
				.hasAuthority("ADMIN").antMatchers("/h2-console/").hasAnyAuthority("USER", "ADMIN").anyRequest()
				.authenticated().and().formLogin().loginProcessingUrl("/login").successForwardUrl("/api/employees/list")
				.permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and().cors().and().csrf().disable();

	}

}

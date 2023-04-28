package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.entity.AuthenticationRequest;
import com.onerivet.entity.Employee;
import com.onerivet.service.Employeeservice;
import com.onerivet.service.JWTService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	 @Autowired
	 private Employeeservice employeeservice;
	 
	 @Autowired
	 private JWTService JWTservice;
	 
	 @Autowired
	 private AuthenticationManager authenticationManager;
	 
	 //to add Employee
	 @PostMapping("/")
	public String SaveEmployee(@RequestBody Employee emp) {
		return employeeservice.save(emp);
	}
	 //get all employee
	 @GetMapping("/")
	 public List<Employee> getallemp(){
		 
		return employeeservice.getAll();
		 
	 }
	 
	 //get single employee
	 @GetMapping("/{id}")
	 public Employee getByEmployeeId(@PathVariable int id) {
		return employeeservice.getById(id);
		 
	 }
	 
	 @PostMapping("/authenticate")
	 public String authenticationAndGetToken(@RequestBody  AuthenticationRequest authrequest) {
		 Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUsername(),authrequest.getPassword()));{
		if(authenticate.isAuthenticated()) {
			 // System.out.println(authrequest.getUsername());
		return JWTservice.genrateToken(authrequest.getUsername());
		}
		else {
			
			throw new UsernameNotFoundException("invalid username request");
		}
		 
	 }

	 }
}

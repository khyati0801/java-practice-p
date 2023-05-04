package com.onerivet.deskbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.onerivet.deskbook.model.entity.Employee;
import com.onerivet.deskbook.model.payload.EmployeeDto;
import com.onerivet.deskbook.service.EmployeeService;

@RestController
@RequestMapping("/api/deskbook")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService; 
	
	
	@GetMapping("/employees")
	public List<EmployeeDto> getAll(){
		return employeeService.getAllEmployee();
		
		
	}

}

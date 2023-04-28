package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.entity.Employee;
import com.onerivet.service.Employeeservice;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	 @Autowired
	 private Employeeservice employeeservice;
	 
	 @PostMapping("/")
	public String SaveEmployee(@RequestBody Employee emp) {
		return employeeservice.save(emp);
	}
	 
	 @GetMapping("/")
	 public List<Employee> getallemp(@RequestParam(value="pagenumber",defaultValue = "0")int pagenumber,
			 						@RequestParam(value="pagesize",defaultValue = "5")int pagesize,
			 						@RequestParam(value="sortingby",defaultValue="name")String sortby){
		 
		return employeeservice.getAll(pagenumber,pagesize,sortby);
		 
	 }

}

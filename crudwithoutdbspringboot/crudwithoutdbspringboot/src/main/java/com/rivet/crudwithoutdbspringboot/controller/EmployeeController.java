package com.rivet.crudwithoutdbspringboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rivet.crudwithoutdbspringboot.pojo.Employee;
import com.rivet.crudwithoutdbspringboot.service.ServiceI;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	public static HashMap<Integer, Employee> employees = new HashMap<>();
	@Autowired
	private ServiceI service;

	// message
	@GetMapping("/message")
	public String Display() {
		return service.message();
	}

	// add user
	@PostMapping("/add")
	public String Addemployee(@RequestBody Employee employee) {
		return service.addemployee(employee);

	}

	// to display user
	@GetMapping("/allemployee")
	public List<Employee> getall() {
		return service.getall();

	}

	// employee by id
	@GetMapping("/allemployee/{id}")
	public Employee getbyid(@PathVariable int id) {
		return service.getbyid(id);

	}

	// delete
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return service.deletebyid(id);
	}

	// update
	@PutMapping("/update")
	public String update(Employee e) {

		return service.update(e);

	}

}

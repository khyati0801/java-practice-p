package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.entitydto.EmployeeDto;
import com.onerivet.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeservice;

	@PostMapping("/save")
	public String saveemployee(@RequestBody EmployeeDto employeedto) {
		return employeeservice.save(employeedto);
	}

	@GetMapping("/employees")
	public List<EmployeeDto> getallemployees() {
		return employeeservice.getAll();

	}

	@GetMapping("/{id}")
	public EmployeeDto getbyid(@PathVariable int id) {
		return employeeservice.getById(id);

	}

	@PutMapping("/update/{id}")
	public String updatebyid(@RequestBody EmployeeDto empdto, @PathVariable int id) {

		return employeeservice.update(empdto, id);

	}

	@DeleteMapping("/delete/{id}")
	public String deletebyid(@PathVariable int id) {

		employeeservice.deleteByid(id);

		return "employee deleted";

	}

	@GetMapping("/firstname")
	public List<EmployeeDto> employeeByFirstname(@RequestParam String firstname) {
		return employeeservice.findByFirstname(firstname);

	}

	@GetMapping("/lastname")
	public List<EmployeeDto> employeeBylastname(@RequestParam String lastname) {
		return employeeservice.findByLastname(lastname);

	}
	
	@GetMapping("/city")
	public List<EmployeeDto> employeeBycity(@RequestParam String city) {
		return employeeservice.findByCity(city);

	}
}
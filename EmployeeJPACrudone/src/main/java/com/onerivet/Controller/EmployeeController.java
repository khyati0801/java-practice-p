package com.onerivet.Controller;

import java.util.List;
import java.util.Map;

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

import com.onerivet.Payload.EmployeeDto;
import com.onerivet.Service.EmployeeService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	//save data to database
	@PostMapping("/save")
	public String saveEmployee(@Valid@RequestBody EmployeeDto employeeDto) {
		return employeeservice.saveEmployee(employeeDto);
	}
	
	//get all employee details with department deatils
	@GetMapping("/all-employees")
	public List<EmployeeDto> getAll(){
		return employeeservice.getAll();
		
	}
	
	//get single employee details
	@GetMapping("/id")
	public EmployeeDto getbyid(@RequestParam  int id) {
		return employeeservice.getById(id);
		
	}
	
	//delete single employee 
	@DeleteMapping("/id")
	public String deletebyId(@RequestParam  int id) {
		return employeeservice.deleteByid(id);
	}
	
	//delete all employee
	@DeleteMapping("/delete")
	public String deleteall() {
		return employeeservice.deleteAll();
	}
	
	//to update employee details
	@PutMapping("/{id}")
	public String updatebyid(@RequestBody EmployeeDto empdto, @PathVariable int id) {

		return employeeservice.update(empdto, id);

	}
	//get name and department name by employeeid
	@GetMapping("/employee-id/{id}")
	public Map<String,String> getDepartmentDetails(@PathVariable int id){
		return employeeservice.getDepartmentDetails(id);
		
	}
	
}

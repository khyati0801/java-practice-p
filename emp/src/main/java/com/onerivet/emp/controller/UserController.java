package com.onerivet.emp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.emppojo.Employee;

@RestController
@RequestMapping("/users")
public class UserController {
	
private static List<Employee> employees=new ArrayList<Employee>();
	@GetMapping("/message")
	public String  Display()
	{
		return "Welcome to SpringBoot";
		
		
	}
	//to add user
	@PostMapping("/add")
	public String addemp(){
		
		
		employees.add(new Employee(01,"jatin","jatin@gmail.com"));
		employees.add(new Employee(02,"jatin2","jatin2@gmail.com"));
		
		return "emplyee added";
			
	}
	
	//to save user
	@PostMapping("/save")
	public String save(Employee e) {
		Employee employee=new Employee();
		employee.setId(e.getId());
		employee.setName(e.getName());
		employee.setEmail(e.getEmail());
		employees.add(employee);
		
		
		
		
		return "employee added";
		
		
		
	}
	
	
	//get all employee
	@GetMapping("/employees")
	public List<Employee> getall(){
		

		return employees;
			
	}
	
	//get employee by id
	@GetMapping("/employee/{id}")
	public Employee getbyid(@PathVariable int id){
		
		for(int i=0;i<employees.size();i++) {
			if(employees.get(i).getId()==id) {
				return  employees.get(i);
			}
		}
		
		return null;	
	}
	
	//delete user by id
	@GetMapping("/delete/{id}")
	public Employee delete(@PathVariable int id){
		
		for(int i=0;i<employees.size();i++) {
			if(employees.get(i).getId()==id) {
				
				return  employees.remove(i);
			}
		}
		
		return null;	
	}
	
	//update data 
	
	@PutMapping("/update")
	public Employee update(Employee employee) {
	
		int idx=0;
		for(int i=0;i<employees.size();i++) {
			if(employees.get(i).getId()==employee.getId()) {
				int id=employee.getId();
				idx=i;
				System.out.println(id);
				break;
				
			}
			
		}
		Employee employee1=new Employee();
		employee1.setId(employee.getId());
		employee1.setName(employee.getName());
		employee1.setEmail(employee.getEmail());
		
		return employees.set(idx,employee1);
		
		
		
	}
	
	
}

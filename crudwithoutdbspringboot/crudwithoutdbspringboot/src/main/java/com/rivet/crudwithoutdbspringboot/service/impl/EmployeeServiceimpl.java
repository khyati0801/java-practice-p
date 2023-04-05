package com.rivet.crudwithoutdbspringboot.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rivet.crudwithoutdbspringboot.pojo.Employee;
import com.rivet.crudwithoutdbspringboot.service.ServiceI;
@Service
public class EmployeeServiceimpl implements ServiceI {
	
	private HashMap<Integer,Employee> employee1=new HashMap<>();
	private List<Employee> list=new ArrayList();
	
	//simple message 
	@Override
	public String message() {
		
		return "helloo";
	}

	//get all employeess details
	@Override
	public List<Employee> getall() {
		
		return employee1.values().stream().collect(Collectors.toList());
	}

	//add new employee
	@Override
	public String addemployee(Employee employee) {
		employee1.put(employee.getId(), employee);
		return "employee added";
	}

	//to get single employee details by id 
	@Override
	public Employee getbyid(int id) {
		Employee e=new Employee();
		e=employee1.get(id);
		return e;
	}

	//to delete single employee 
	@Override
	public String deletebyid(int id) {
		
		employee1.remove(id);
		return "user deleted";
	}

	//to update employee details
	@Override
	public String update(Employee e) {
		employee1.replace(e.getId(), e);

		return "data updated";
	}
	
	

}

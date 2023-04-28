package com.onerivet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.onerivet.entity.Employee;
import com.onerivet.repository.EmployeeRepository;
import com.onerivet.service.Employeeservice;
@Service
public class EmployeeServiceimpl implements Employeeservice {
	
	 @Autowired
	 private EmployeeRepository emplyeerepository;

	@Override
	public String save(Employee employee) {
		emplyeerepository.save(employee);
		return "data saved";
	}

//	@Override
//	public List<Employee> getAll(int ) {
//		
//		return emplyeerepository.findAll();
//	}
	 
	 
	 



	@Override
	public List<Employee> getAll(int pageNumber, int pagesize,String sortby) {
    Pageable pageable = PageRequest.of(pageNumber, pagesize,Sort.by(sortby).descending());
	 Page<Employee> employee=emplyeerepository.findAll(pageable);
		return employee.getContent();
				
	}}

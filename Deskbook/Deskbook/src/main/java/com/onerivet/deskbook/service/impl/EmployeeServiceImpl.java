package com.onerivet.deskbook.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.deskbook.model.entity.Employee;
import com.onerivet.deskbook.model.payload.EmployeeDto;
import com.onerivet.deskbook.repository.EmployeeRepository;
import com.onerivet.deskbook.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeereposotory;
	
	@Autowired
	private ModelMapper modelmaper;

	
	@Override
	public List<EmployeeDto> getAllEmployee() {
		
		return employeereposotory.findAll().stream().map((employee)-> this.modelmaper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
	}

}
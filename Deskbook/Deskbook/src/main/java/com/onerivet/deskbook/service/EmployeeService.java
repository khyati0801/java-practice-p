package com.onerivet.deskbook.service;

import java.util.List;

import com.onerivet.deskbook.model.entity.Employee;
import com.onerivet.deskbook.model.payload.EmployeeDto;

public interface EmployeeService {
	
	public List<EmployeeDto> getAllEmployee();

}

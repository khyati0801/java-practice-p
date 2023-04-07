package com.onerivet.service;


import java.util.List;

import com.onerivet.entity.Employee;
import com.onerivet.entitydto.EmployeeDto;

public interface EmployeeService {

	public String save(EmployeeDto employee);
	public List<EmployeeDto> getAll();
	public EmployeeDto getById(int id);
	public String update(EmployeeDto employee,int id);
	public String deleteByid(int id);
	public List<EmployeeDto> findByFirstname(String firstname);
	public List<EmployeeDto> findByLastname(String lastname);
	public List<EmployeeDto> findByCity(String city);
	
}
package com.onerivet.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.entity.Employee;
import com.onerivet.entitydto.EmployeeDto;
import com.onerivet.repository.EmployeeRepository;
import com.onerivet.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeerepository;

	private Employee EmployeeDtotoEmployee(EmployeeDto employeedto) {
		
		Employee employee=new Employee();
		employee.setId(employeedto.getId());
		employee.setFirstName(employeedto.getFirstName());
		employee.setLastName(employeedto.getLastName());
		employee.setCity(employeedto.getCity());
		employee.setPassword(employeedto.getPassword());
		employee.setPhoneNumber(employeedto.getPhoneNumber());
		return employee;
		
	}
	
	private EmployeeDto EmployeeToEmployeeDto(Employee employee) {
		EmployeeDto employeedto=new EmployeeDto();
		
		employeedto.setId(employee.getId());
		employeedto.setFirstName(employee.getFirstName());
		employeedto.setLastName(employee.getLastName());
		employeedto.setCity(employee.getCity());
		employeedto.setPassword(employee.getPassword());
		employeedto.setPhoneNumber(employee.getPhoneNumber());
		return employeedto;
		
	}
	
	
	@Override
	public String save(EmployeeDto employee) {
		employeerepository.save(EmployeeDtotoEmployee(employee));
		return "employee details save";
	}

	@Override
	public List<EmployeeDto> getAll() {
		 
		return employeerepository.findAll().stream().map(this::EmployeeToEmployeeDto).collect(Collectors.toList());
		 
	}
   
	@Override
	public EmployeeDto getById(int id) {
		return 	this.EmployeeToEmployeeDto(employeerepository.findById(id).get());
		
	}

	
	@Override
	public String update(EmployeeDto employee,int id) {
		Employee employee2 = this.employeerepository.findById(id).get();
		employee2.setFirstName(employee.getFirstName());
		employee2.setLastName(employee.getLastName());
		employee2.setCity(employee.getCity());
		employee2.setPassword(employee.getPassword());
		employee2.setPhoneNumber(employee.getPhoneNumber());
		
		employeerepository.save(employee2);
	
		
		return "employee details updated";
	}

	@Override
	public String deleteByid(int id) {
		 employeerepository.deleteById(id);
		return "employee deleted";
	}

	@Override
	public List<EmployeeDto> findByFirstname(String firstname) {
		
		return employeerepository.findByFirstName(firstname).stream().map(this::EmployeeToEmployeeDto).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDto> findByLastname(String lastname) {
		
		return employeerepository.findByLastName(lastname).stream().map(this::EmployeeToEmployeeDto).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDto> findByCity(String city) {
		
		return employeerepository.findByCity(city).stream().map(this::EmployeeToEmployeeDto).collect(Collectors.toList());
	}

	

	
	


	

}

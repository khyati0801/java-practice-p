package com.onerivet.Service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.onerivet.Entity.Address;
import com.onerivet.Entity.Department;
import com.onerivet.Entity.Employee;
import com.onerivet.Payload.DepartmentDto;
import com.onerivet.Payload.EmployeeDto;
import com.onerivet.Repository.EmployeeRepository;
import com.onerivet.Service.EmployeeService;
import com.onerivet.exception.ResourceNotFoundException;
@Service
public class EmployeeServiceimpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeerepository;

	@Autowired
	private ModelMapper modelMapper;
	
	public Employee EmployeeDtoToEmployee(EmployeeDto employeedto) {
		Employee employee = this.modelMapper.map(employeedto, Employee.class);
		return employee;	
	}
	
	public EmployeeDto EmployeeToEmployeeDto(Employee employee) {
		
		EmployeeDto employeeDto = this.modelMapper.map(employee, EmployeeDto.class);
		return employeeDto;	
	}

	@Override
	public String saveEmployee(EmployeeDto employee) {
		Employee employee1 = EmployeeDtoToEmployee(employee);
		employee1.getDepartment().setEmployee(employee1);
		employeerepository.save(employee1);
		return "employee details Saved";
		
	}

	@Override
	public List<EmployeeDto> getAll() {
		// TODO Auto-generated method stub
		return employeerepository.findAll().stream().map(this::EmployeeToEmployeeDto).collect(Collectors.toList());
	}


	@Override
	public EmployeeDto getById(int id) {
		 Employee emp = this.employeerepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this"+id));
		
		return this.EmployeeToEmployeeDto(emp);
		/*
		 * try { Employee emp = this.employeerepository.findById(id).get(); return
		 * this.EmployeeToEmployeeDto(emp); } catch(ResourceNotFoundException ex) {
		 * throw new ResourceNotFoundException("User not found with this"+id);
		 * 
		 * } catch(MethodArgumentNotValidException ex) { throw new
		 * MethodArgumentNotValidException("User not found with this",ex.getCause());
		 * 
		 * }
		 */
	}

	
	@Override
	public String update(EmployeeDto employee,int id) {
		Employee employee2 = this.employeerepository.findById(id).get();
		
		
		Employee employee3 = this.EmployeeDtoToEmployee(employee);
		employee3.setId(employee2.getId());
		employee3.getDepartment().setDepartmentId(employee2.getId());
		employee3.getDepartment().setEmployee(employee3);
		employeerepository.save(employee3);
	
		
		
//		employee2.setFirstName(employee.getFirstName());
//		employee2.setLastName(employee.getLastName());
//		employee2.setAddress(this.modelMapper.map(employee.getAddress(), Address.class));
//		employee2.setPassword(employee.getPassword());
//		employee2.setPhoneNumber(employee.getPhoneNumber());
//		employee2.setEmail(employee.getEmail());
//		employee2.setJoiningDate(employee.getJoiningDate());
//		employee2.setAge(employee.getAge());
//		employee2.setStatus(employee.isStatus());
//		employee2.setDepartment(this.modelMapper.map(employee.getDepartment(), Department.class));
//		
//		
//	
		
		return "employee details updated";
	}

	@Override
	public String deleteByid(int id) {
		
		Employee emp=this.EmployeeDtoToEmployee(this.getById(id));
		 employeerepository.delete(emp);
		return "employee deleted";
	}

	@Override
	public String deleteAll() {
		
		 employeerepository.deleteAll();
		 return "all employees deleted";
	}

	@Override
	public Map<String, String> getDepartmentDetails(int id) {
		
		return employeerepository.getDepartmentDetailsByEmployeeId(id);
	}
	
	

}

package com.onerivet.Service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.Entity.Department;
import com.onerivet.Entity.Employee;
import com.onerivet.Payload.DepartmentDto;
import com.onerivet.Payload.EmployeeDto;
import com.onerivet.Repository.DepartmentRepository;

@Service
public class DepartmentServiceimpl implements com.onerivet.Service.DepartmentService {
	
	@Autowired
	DepartmentRepository departmentrepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Department DepartmentDtoToDepartment(DepartmentDto departmentdto) {
		Department department = this.modelMapper.map(departmentdto, Department.class);
		return department;	
	}
	
	public DepartmentDto DepartmentToDepartmentDto(Department department) {
		
		DepartmentDto departmentDto = this.modelMapper.map(department, DepartmentDto.class);
		return departmentDto;	
	}

	@Override
	public String save(DepartmentDto department) {
		
		 departmentrepository.save(DepartmentDtoToDepartment(department));
		return "Department details saved";
	}

}

package com.onerivet.Service;

import java.util.List;
import java.util.Map;

import com.onerivet.Payload.EmployeeDto;



public interface EmployeeService {
	public String saveEmployee(EmployeeDto employee);
    public List<EmployeeDto> getAll();
    public EmployeeDto getById(int id);
	public String update(EmployeeDto employee,int id);
	public String deleteByid(int id);
	public String deleteAll();
	
	public Map<String,String> getDepartmentDetails(int id);
	
}

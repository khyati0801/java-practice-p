package com.rivet.crudwithoutdbspringboot.service;

import java.util.List;

import com.rivet.crudwithoutdbspringboot.pojo.Employee;

public interface ServiceI {
	public String  message() ;
	public List<Employee> getall();
	String addemployee(Employee employee);
	public Employee getbyid(int id);
	public String deletebyid(int id);
	public String update(Employee e);
	
}

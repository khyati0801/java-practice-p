package com.onerivet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.Payload.DepartmentDto;
import com.onerivet.Service.DepartmentService;

@RestController
@RequestMapping("/Departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentservice;
	
//	@PostMapping("/save")
//	public String  save(DepartmentDto  departmentdto) {
//		return departmentservice.save(departmentdto);}
}

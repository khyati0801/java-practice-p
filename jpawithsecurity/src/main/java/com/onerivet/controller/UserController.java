package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.entity.User;
import com.onerivet.service.impl.UserSeviceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserSeviceImpl userserviceimpl;
	
	@PostMapping("/add")
	public String saveuser(@RequestBody User user) {
		return userserviceimpl.saveUSer(user);}
	
	@GetMapping("/")
	public List<User> getallUsers(){
		return userserviceimpl.getUsers();
		
	}
	
	
	
	

}

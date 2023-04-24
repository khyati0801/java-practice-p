package com.onerivet.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.payload.UserDto;


@RestController
@RequestMapping("/users")
public class UserController  {
	
	@Autowired
	com.onerivet.Service.impl.Userimpl userimple;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody UserDto userdto) {
		return userimple.saveUSer(userdto);
		
	}

	@GetMapping("/allusers")
	public List<UserDto> getUsers(){
		return userimple.getUsers();
		
	}
	
	@GetMapping("/user-details-by-id/{id}")
	public Map<String,String> getDetailsUserbyid(@PathVariable int id){
		return userimple.getUserDetailsbyId(id);}
	
}

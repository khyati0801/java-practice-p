package com.onerivet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.entity.User;
import com.onerivet.service.impl.UserSeviceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserSeviceImpl userserviceimpl;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@PostMapping("/add")
	public String saveuser(@RequestBody User user) {
		return userserviceimpl.saveUSer(user);}
	
	@GetMapping("/")
	public List<User> getallUsers(@RequestParam("username") String username, @RequestParam("password") String password){
		Authentication authenticate = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
		if(authenticate.isAuthenticated()) {
			return userserviceimpl.getUsers();
		}
		return new ArrayList<User>();
	}
	
	
	
	

}

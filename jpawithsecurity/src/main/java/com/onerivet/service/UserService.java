package com.onerivet.service;

import java.util.List;

import com.onerivet.entity.User;



public interface UserService {
	
	public String saveUSer(User user);
	public List<User> getUsers();

}

package com.onerivet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.entity.User;
import com.onerivet.repository.UserRepository;
import com.onerivet.service.UserService;
@Service
public class UserSeviceImpl implements UserService {
	@Autowired
	UserRepository userrepository;
	@Override
	public String saveUSer(User user) {
		
		userrepository.save(user);
		return " data save";
	}

	@Override
	public List<User> getUsers() {
		
		return userrepository.findAll();
	}

}

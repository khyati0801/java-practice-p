package com.onerivet.Service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.enitity.User;
import com.onerivet.payload.UserDto;
import com.onerivet.repository.UserRepository;

@Service
public class Userimpl implements com.onerivet.Service.UserService {
	
	@Autowired
	UserRepository userrepository;
	
	@Autowired
    private ModelMapper modelmapper;
	
	
	public User userDtoTouser(UserDto userDto) {
		User user = this.modelmapper.map(userDto, User.class);
		return user;	
	}
	
	public UserDto userTouserDto(User user) {
		
		UserDto userDto = this.modelmapper.map(user, UserDto.class);
		return userDto;	
	}
		
	

	@Override
	public String saveUSer(UserDto user) {
		//System.out.println(user);
		User user1=userDtoTouser(user);
		//System.out.println(user1);
		userrepository.save(user1);
		
		return "Data Saved";
		
		
	}

	@Override
	public List<UserDto> getUsers() {
		
		return userrepository.findAll().stream().map(this::userTouserDto).collect(Collectors.toList());
	}

	@Override
	public Map<String, String> getUserDetailsbyId(int id) {
		
		return userrepository.getUserdetailsByid(id);
	} 
	
	

}

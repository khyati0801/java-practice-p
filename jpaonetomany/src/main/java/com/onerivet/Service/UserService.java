package com.onerivet.Service;

import java.util.List;
import java.util.Map;

import com.onerivet.enitity.User;
import com.onerivet.payload.UserDto;

public interface UserService {
	
	public String saveUSer(UserDto user);
	public List<UserDto> getUsers();
	public Map<String,String> getUserDetailsbyId(int id);

}

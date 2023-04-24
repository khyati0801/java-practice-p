package com.onerivet.payload;

import java.util.List;

import com.onerivet.enitity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
	
	
	private int userid;
	private String name;
	private int age;
	private List<AddressDto> address;
	private UserDto user;
}

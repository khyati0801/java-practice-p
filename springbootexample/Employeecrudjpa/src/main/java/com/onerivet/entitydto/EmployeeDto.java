package com.onerivet.entitydto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	private int id;

	private String firstName;

	private String lastName;

	private String city;

	private String password;

	private long phoneNumber;

}

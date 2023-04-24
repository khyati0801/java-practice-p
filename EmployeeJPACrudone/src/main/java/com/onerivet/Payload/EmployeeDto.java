package com.onerivet.Payload;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.onerivet.Entity.Address;
import com.onerivet.Entity.Department;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDto {
	
	private int id;
	
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	
	@NotNull
	private AddressDto address;

	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password must contain at least (one digit [0-9],"
			+"one lowercase Latin character [a-z],"
			+"one uppercase Latin character [A-Z]"
			+"one special character like ! @ # & ( ),length 8 to 20 characters)")
	private String password;
	
	@NotEmpty
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid phoneNo")
	private String phoneNumber;

	
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email Address")
	private String email;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate joiningDate;

	@Range(min = 18, message = "minimum age should be 18")
	private int age;
	
	@NotNull
	private boolean Status;
	
	private DepartmentDto department;


}

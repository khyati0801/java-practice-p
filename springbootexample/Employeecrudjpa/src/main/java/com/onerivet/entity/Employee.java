package com.onerivet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Employee_Details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	@Column(name="emp_firstname")
	private String firstName;
	
	@Column(name="emp_lastname")
	private String lastName;
	
	@Column(name="emp_city")
	private String city;
	
	@Column(name="emp_password")
	private String password;
	
	@Column(name="emp_contactno")
	private long phoneNumber;
	

}

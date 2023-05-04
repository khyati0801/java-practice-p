package com.onerivet.deskbook.model.payload;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	private String phoneNumber;
	private String emailId;
	private String project;
	private ModeOfWorkDto modeofdworkId;
	private DesignationDto DesignationId;
	private SeatConfigurationDto seatConfigurationId;
	private Set<RoleDto> role;
	private Set<WorkingDayDto> workingDays;
	
	
	
	
	
	

}

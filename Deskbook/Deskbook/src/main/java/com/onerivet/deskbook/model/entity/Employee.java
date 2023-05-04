package com.onerivet.deskbook.model.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employee", schema = "dbo")
public class Employee {
	
	@Id
	@Column(name = "EmployeeId")
	private int id;

	@Column(name = "UserId")
	private String userId;

	@Column(name = "EmailId")
	private String emailId;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@Column(name = "Project")
	private String project;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ModeOfWorkId")
	private ModeOfWork modeOfWork;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DesignationId")
	private Designation designation;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SeatConfigurationId")
	private SeatConfiguration seatConfiguration;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EmployeeRole", schema = "dbo", joinColumns = @JoinColumn(name = "EmployeeId"), inverseJoinColumns = @JoinColumn(name = "RoleId"))
	private Set<Role> roles;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EmployeeWorkingDays", schema = "dbo", joinColumns = @JoinColumn(name = "EmployeeId"), inverseJoinColumns = @JoinColumn(name = "WorkingDayId"))
	private Set<WorkingDay> workingDays;
	
	
	
	
	
	

}

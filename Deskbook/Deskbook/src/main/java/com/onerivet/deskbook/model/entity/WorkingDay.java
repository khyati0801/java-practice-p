package com.onerivet.deskbook.model.entity;

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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "WorkingDay", schema = "Ref")
public class WorkingDay {
	
	@Id
	@Column(name = "WorkingDayId")
	private int id;
	@Column(name = "WorkingDayName")
	private String day;

}

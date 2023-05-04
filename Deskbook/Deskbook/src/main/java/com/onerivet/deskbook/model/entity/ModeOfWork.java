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
@Table(name = "ModeOfWork", schema = "Ref")
public class ModeOfWork {
	
	@Id
	@Column(name = "ModeOfWorkId")
	private int id;
	
	@Column(name = "ModeOfWorkName")
	private String modeOfWorkName;

}
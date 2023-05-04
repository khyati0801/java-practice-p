package com.onerivet.deskbook.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "SeatConfiguration", schema = "dbo")
public class SeatConfiguration {
	
	@Id
	@Column(name = "SeatConfigurationId")
	private int id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CityId")
	private City city;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FloorId")
	private Floor floor;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ColumnId")
	private Columns column;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SeatNumberId")
	private SeatNumber seatNumber;

	public SeatConfiguration(City city, Floor floor, Columns column, SeatNumber seatNumber) {
		super();
		this.city = city;
		this.floor = floor;
		this.column = column;
		this.seatNumber = seatNumber;
	}
	

}

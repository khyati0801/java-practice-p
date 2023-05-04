package com.onerivet.deskbook.model.payload;

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
public class SeatConfigurationDto {
	
	
	private int id;
	
	private CityDto cityId;
	
	private FloorDto floorId;
	
	private SeatNumberDto SeatNumberId;
	

}

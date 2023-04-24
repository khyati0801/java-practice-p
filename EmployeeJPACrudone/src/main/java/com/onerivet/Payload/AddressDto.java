package com.onerivet.Payload;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
	
	private String streetname;
	
	private String cityname;
	@Pattern(regexp = "[0-9]{6}")
	private String zipcode;
}

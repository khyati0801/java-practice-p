package com.onerivet;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaOnetomanyMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaOnetomanyMappingApplication.class, args);
	}

	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
		
	}
}

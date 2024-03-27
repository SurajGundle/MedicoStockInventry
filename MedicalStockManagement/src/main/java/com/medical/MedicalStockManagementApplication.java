package com.medical;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class MedicalStockManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalStockManagementApplication.class, args);
	}

}

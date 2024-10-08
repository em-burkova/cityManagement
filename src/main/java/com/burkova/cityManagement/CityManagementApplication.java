package com.burkova.cityManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CityManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityManagementApplication.class, args);
	}

}

package com.marshall.crazyairman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AirCompaniesManagementSystemApp {
	public static void main(String[] args) {
		SpringApplication.run(AirCompaniesManagementSystemApp.class, args);
	}
}


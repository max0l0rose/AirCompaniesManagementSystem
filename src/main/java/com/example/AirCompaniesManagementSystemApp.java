package com.example;

import com.example.model.Airplane;
import com.example.model.Company;
import com.example.repository.AirplaneRepository;
import com.example.repository.CompanyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirCompaniesManagementSystemApp {

//	@Bean
//	boolean init(AirplaneRepository airplaneRepository, CompanyRepository companyRepository) {
//
//		Company company1 = Company.builder().name("Company1").build();
//
//		airplaneRepository.save(Airplane.builder().name("Plane1").company(company1).build());
//
//		//airplaneRepository.save(Airplane.builder().name("Plane2").build());
//
//		return true;
//	}

	public static void main(String[] args) {
		SpringApplication.run(AirCompaniesManagementSystemApp.class, args);
	}

}

package com.example;

import com.example.model.Airplane;
import com.example.model.Company;
import com.example.model.Flight;
import com.example.repository.AirplaneRepository;
import com.example.repository.CompanyRepository;
import com.example.repository.FlightRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AirCompaniesManagementSystemApp {

	@Bean
	boolean init(AirplaneRepository airplaneRepository,
	             CompanyRepository companyRepository,
				FlightRepository flightRepository)
	{
//		Company company1 = Company.builder().name("Company1").build();
//		airplaneRepository.save(Airplane.builder().name("Plane1").company(company1).build());
//		//airplaneRepository.save(Airplane.builder().name("Plane2").build());

		Flight flight = new Flight();
		flightRepository.save(flight);

//		flight.setName("nnnn 3333");
//
//		flightRepository.save(flight);
//		flightRepository.save(flight);

		return true;
	}

	public static void main(String[] args) {
		SpringApplication.run(AirCompaniesManagementSystemApp.class, args);
	}

}

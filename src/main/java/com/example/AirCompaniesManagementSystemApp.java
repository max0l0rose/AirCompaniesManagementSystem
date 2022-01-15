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
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableJpaAuditing
public class AirCompaniesManagementSystemApp {

//	Flight flight = new Flight();
//
//	@Bean
//	synchronized boolean init(AirplaneRepository airplaneRepository,
//	             CompanyRepository companyRepository,
//				FlightRepository flightRepository)
//	{
////		Company company1 = Company.builder().name("Company1").build();
////		airplaneRepository.save(Airplane.builder().name("Plane1").company(company1).build());
////		//airplaneRepository.save(Airplane.builder().name("Plane2").build());
//
//		flightRepository.save(flight);
//
////		flight.setName("nnnn 3333");
////
////		flightRepository.save(flight);
////		flightRepository.save(flight);
//
//		return true;
//	}
//
//
//	@Bean
//	boolean init2(AirplaneRepository airplaneRepository,
//	             CompanyRepository companyRepository,
//	             FlightRepository flightRepository)
//	{
//		flight.setName("aaaa");
//		flightRepository.save(flight);
//		return true;
//	}
//
//
//	@Bean
//	boolean init3(AirplaneRepository airplaneRepository,
//	              CompanyRepository companyRepository,
//	              FlightRepository flightRepository)
//	{
//		//flight.setVersion(1);
//		Flight flight = flightRepository.findById(1L).get();
//		flight.setName("bbbb");
//		flightRepository.save(flight);
//		return true;
//	}



	public static void main(String[] args) {
		SpringApplication.run(AirCompaniesManagementSystemApp.class, args);
	}

}

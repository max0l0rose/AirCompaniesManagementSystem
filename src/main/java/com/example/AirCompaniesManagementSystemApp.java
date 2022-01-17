package com.example;

import com.example.model.*;
import com.example.repository.AirplaneRepository;
import com.example.repository.CompanyRepository;
import com.example.repository.FlightRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableJpaAuditing
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AirCompaniesManagementSystemApp {

	final AirplaneRepository airplaneRepository;
	final CompanyRepository companyRepository;
	final FlightRepository flightRepository;

	//	Flight flight = new Flight();
//
//	@Bean
//	synchronized boolean init()
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


//	@Bean
//	boolean init2() {
////		flight.setName("aaaa");
////		flightRepository.save(flight);
//		return true;
//	}



//	//@Bean
//	// DB NOT ready
//	@PostConstruct
//	boolean init3()
//	{
//		//flight.setVersion(1);
//		//Flight flight = flightRepository.findById(4L).get();
////		flight.setName("bbbb");
////		flightRepository.save(flight);
//		return true;
//	}


	// DB ready!
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//Flight flight = flightRepository.findById(4L).get();

//		Company company = companyRepository.findById(1L).get();
//		airplaneRepository.setCompany(3L, company);

		//airplaneRepository.setCompany(3L, 2L);

		List<Map.Entry<String, Integer>> list = companyRepository
				.findCompanyFlightsByStatus("Company1"
				//,FlightStatus.PENDING
		);



		String n = list.get(0).getKey();
		int s = list.get(0).getValue();

		List<Flight> flightList = flightRepository.findAllActiveStartedMoreThan24HoursAgo(FlightStatus.COMPLETED);



		Airplane airplane = Airplane.builder()
	                    .name("Super airplane")
	                    .planeCreated(
			                    //LocalDate.parse("2007-05-02")
			                    LocalDate.parse("2007-05-02")
	                    )
						.build();
		airplaneRepository.save(airplane);

		int a = 1;
	}


//	// Works
//	@EventListener(ApplicationReadyEvent.class)
//	public void doSomethingAfterStartup() {
//		System.out.println("hello world, I have just started up");
//	}


	public static void main(String[] args) {
		SpringApplication.run(AirCompaniesManagementSystemApp.class, args);
	}

}


//// DB ready!
//@Component
//class AppStartupRunner implements ApplicationRunner {
//
//	@Override
//	public void run(ApplicationArguments args)
//	{
//	}
//}

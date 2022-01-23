package com.marshall.crazyairman;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AirCompaniesManagementSystemApp {

//	final FlightService flightService;


//	@Bean
//	public RepresentationModelProcessor<EntityModel<Flight>> personProcessor() {
//		return new RepresentationModelProcessor<EntityModel<Flight>>() {
//			@Override
//			public EntityModel<Flight> process(EntityModel<Flight> model) {
//
//				model.add(Link.of("http://localhost:8080/people"));
//				return model;
//			}
//		};
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


//	// ---DB ready!
//	@EventListener
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		//Flight flight = flightRepository.findById(4L).get();
//
////		Company company = companyRepository.findById(1L).get();
////		airplaneRepository.setCompany(3L, company);
//
//		//airplaneRepository.setCompany(3L, 2L);
//
////		List<Map.Entry<String, BigInteger>> list = companyService
////				.findCompanyFlightsByStatus("Company1"
////				,FlightStatus.PENDING
////		);
////
////
////
////		String n = list.get(0).getKey();
////		BigInteger s = list.get(0).getValue();
////
////		List<Flight> flightList = flightService.findAllActiveStartedMoreThan24HoursAgo(FlightStatus.COMPLETED);
//
//
//
////		Airplane airplane = Airplane.builder()
////	                    .name("Super airplane3")
////	                    .planeCreated(
////			                    //LocalDate.parse("2007-05-02")
////			                    LocalDate.parse("2007-05-02")
////	                    )
////					.fuelCapacity(1200)
////						.build();
////		airplaneService.save(airplane);
//	}


//	// Works
//	@EventListener(ApplicationReadyEvent.class)
//	public void doSomethingAfterStartup() {
//		System.out.println("hello world, I have just started up");
//	}


	public static void main(String[] args) {
		SpringApplication.run(AirCompaniesManagementSystemApp.class, args);
	}

}


//// ---DB ready!
//@Component
//class AppStartupRunner implements ApplicationRunner {
//
//	@Override
//	public void run(ApplicationArguments args)
//	{
//	}
//}

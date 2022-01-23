package com.marshall.crazyairman.controller;

import com.marshall.crazyairman.model.Flight;
import com.marshall.crazyairman.model.FlightStatus;
import com.marshall.crazyairman.service.FlightService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.StaleObjectStateException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
@RequestMapping("/flight")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
//@RepositoryRestResource(path = "flight")
public class FlightController {
	final FlightService flightService;


//	@GetMapping("/flights/search/qqq")
//	ResponseEntity<RepresentationModel<Flight>> qqq(
//			//@PathVariable long id
//	) {
//			//Flight flight = new Flight();
//
//		RepresentationModel<Flight> resources = new RepresentationModel<>();
//		resources.add(linkTo(methodOn(FlightController.class).qqq()).withSelfRel());
//
////			flight.add(linkTo(methodOn(FlightController.class).setStatus(flight, 999)).withRel(LinkRelation.of("qqqq")));
//			return ResponseEntity.ok(resources);
////		try {
////		} catch (NoSuchElementException e) {
////		}
////		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Flight());
//	}


	// 7
	@PatchMapping(value = "/setStatus/{id}")
	ResponseEntity<Flight> setStatus(@RequestBody int flightStatus,
	                                 @PathVariable long id) {
		try {
			Flight flight = flightService.findById(id).get();
			//flight.setStatus(flightStatus);
			flightService.setStatus(flight, FlightStatus.values()[flightStatus]);
			flight = flightService.update(flight);
			return ResponseEntity.ok(flight);
		} catch (DataIntegrityViolationException | StaleObjectStateException | NoSuchElementException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Flight());
	}

}



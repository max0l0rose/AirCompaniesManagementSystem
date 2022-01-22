package com.example.controller;

import com.example.model.Flight;
import com.example.model.FlightStatus;
import com.example.service.FlightService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.StaleObjectStateException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


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



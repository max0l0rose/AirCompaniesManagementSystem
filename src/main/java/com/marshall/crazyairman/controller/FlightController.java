package com.marshall.crazyairman.controller;

import com.marshall.crazyairman.model.Flight;
import com.marshall.crazyairman.model.FlightStatus;
import com.marshall.crazyairman.service.FlightService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.StaleObjectStateException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@RestController
@RequestMapping("/flight")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightController {
	final FlightService flightService;


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



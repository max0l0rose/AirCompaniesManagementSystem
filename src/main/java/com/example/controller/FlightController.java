package com.example.controller;

import com.example.model.Flight;
import com.example.service.FlightService;
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

@RestController
@RequestMapping("/flight")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class FlightController {
	final FlightService flightService;


	// 7
	@PatchMapping(value = "/{id}")
	ResponseEntity<Flight> setStatus(@RequestBody Flight flight, @PathVariable long id) {
		try {
			if (id>0)
				flight.setId(id);
			flight = flightService.update(flight);
			return ResponseEntity.ok(flight);
		} catch (DataIntegrityViolationException | StaleObjectStateException | NoSuchElementException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Flight());
	}

}



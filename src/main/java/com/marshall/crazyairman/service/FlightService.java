package com.marshall.crazyairman.service;

import com.marshall.crazyairman.model.Flight;
import com.marshall.crazyairman.model.FlightStatus;
import com.marshall.crazyairman.repository.FlightRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class FlightService
{
	final FlightRepository flightRepository;

	public Optional<Flight> findById(long id) {
		return flightRepository.findById(id);
	}

	public Flight setStatus(Flight flight, FlightStatus flightStatus) {
		switch (flightStatus) {
			case COMPLETED:
				flight.setEndedDateTime(OffsetDateTime.now());
				break;
			case ACTIVE:
				flight.setStartedDateTime(OffsetDateTime.now());
				break;
			case DELAYED:
				flight.setDelayStartedDateTime(OffsetDateTime.now());
				break;
		}
		flight.setStatus(flightStatus);
		return flightRepository.save(flight);
	}


	public Flight update(Flight flight) {
		Flight flightOld = flightRepository.findById(flight.getId()).get();
		flightOld.updateFrom(flight);
		return flightRepository.save(flightOld);
	}
}

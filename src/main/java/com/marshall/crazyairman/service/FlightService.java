package com.marshall.crazyairman.service;

import com.marshall.crazyairman.model.Flight;
import com.marshall.crazyairman.model.FlightStatus;
import com.marshall.crazyairman.repository.FlightRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class FlightService
{
	final FlightRepository flightRepository;


	public Optional<Flight> findByName(String name) {
		return Optional.ofNullable(flightRepository.findByName(name));
	}


	public Page<Flight> getPage(Pageable page) {
		return flightRepository.findAll(page);
	}


	public Optional<Flight> findById(long id) {
		return flightRepository.findById(id);
	}


//	public Flight save(Flight airplane) {
//		return flightRepository.save(airplane);
//	}


	public Flight add(Flight flight) {
		flight.setStatus(FlightStatus.PENDING);
		return flightRepository.save(flight);
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
		Flight flightOld = findById(flight.getId()).get();
		flightOld.updateFrom(flight);
		return flightRepository.save(flightOld);
	}

	public void delete(long id) {
		flightRepository.deleteById(id);
	}


	public List<Flight> findAllActiveStartedMoreThan24HoursAgo(FlightStatus flightStatus) {
		return flightRepository.findAllActiveStartedMoreThan24HoursAgo(flightStatus);
	}

}

package com.marshall.crazyairman.repository;

import com.marshall.crazyairman.model.Flight;
import com.marshall.crazyairman.model.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	Flight findByName(String name);

	@Query(value = "SELECT * \n" +
	               "FROM flight f \n" +
	               "INNER JOIN company c on c.id = f.company_id \n" +
	               "WHERE f.status = :#{#flightStatus.ordinal()} \n" +
	               "and f.started_date_time < DATE_SUB(NOW(), INTERVAL 1 DAY)",
			nativeQuery = true)
	List<Flight> findAllActiveStartedMoreThan24HoursAgo(FlightStatus flightStatus);
}

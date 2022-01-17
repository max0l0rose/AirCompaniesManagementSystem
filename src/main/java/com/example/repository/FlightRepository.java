package com.example.repository;

import com.example.model.Flight;
import com.example.model.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query(value = "SELECT * \n" +
	               "FROM flight f \n" +
	               "INNER JOIN company c on c.id = f.company_id \n" +
	               "WHERE f.status = :#{#flightStatus.ordinal()} \n" +
	               "and f.started_date_time < DATE_SUB(NOW(), INTERVAL 1 DAY)",
			nativeQuery = true)
	List<Flight> findAllActiveStartedMoreThan24HoursAgo(FlightStatus flightStatus);

}
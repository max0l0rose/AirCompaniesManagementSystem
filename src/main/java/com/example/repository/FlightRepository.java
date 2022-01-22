package com.example.repository;

import com.example.model.Airplane;
import com.example.model.Flight;
import com.example.model.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	Flight findByName(String name);

//	@Query(value = "SELECT * \n" +
//			               "FROM flight f \n" +
//						   "LIMIT 1"
//			,nativeQuery = true)
//	//@RestResource(exported = true)
//	Object[] qqqq();


	@Query(value = "SELECT * \n" +
	               "FROM flight f \n" +
	               "INNER JOIN company c on c.id = f.company_id \n" +
	               "WHERE f.status = :#{#flightStatus.ordinal()} \n" +
	               "and f.started_date_time < DATE_SUB(NOW(), INTERVAL 1 DAY)",
			nativeQuery = true)
	List<Flight> findAllActiveStartedMoreThan24HoursAgo(FlightStatus flightStatus);

}
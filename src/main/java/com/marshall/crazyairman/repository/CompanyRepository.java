package com.marshall.crazyairman.repository;

import com.marshall.crazyairman.model.Company;
import com.marshall.crazyairman.model.Flight;
import com.marshall.crazyairman.model.FlightStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	Company findByName(String name);

	@EntityGraph(value = "graph-plane-company")
	Company findById(long id);

	// task 3
	@Query(value = "SELECT f " +
			               "FROM Flight f " +
			               "LEFT JOIN f.company c " +
			               "WHERE c.name = :companyName and f.status = :flightStatus")
	List<Flight> findCompanyFlightsByStatus(String companyName
	                                         , FlightStatus flightStatus
	);
}
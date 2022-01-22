package com.example.repository;

import com.example.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@Repository
//@RepositoryRestResource()
public interface CompanyRepository extends JpaRepository<Company, Long> {

	//@Lock(LockModeType.READ);
	Company findByName(String name);

//	@Transactional
//	@Modifying
//	@Query(value = "INSERT INTO Company (name, type) " +
//			               "VALUES (:name , 1)", //:#{#flightStatus.ordinal()}
//			nativeQuery = true)
//	int save1(String name);

//	@Transactional
//	@Modifying
//	@Query(value = "INSERT INTO Company (name, type) " +
//			               "VALUES (:c , 1)", //:#{#flightStatus.ordinal()}
//			nativeQuery = true)
//	int save2(Company c);



	//3
//	//@Transactional
//	//@Modifying
//	@Query(value = "SELECT f.* \n" +
//			               "FROM flight f \n" +
//			               "LEFT JOIN company c on c.id = f.company_id \n" +
//			               "WHERE c.name = :companyName \n" +
//			               "AND f.status = :flightStatus", //:#{#flightStatus.ordinal()}
//			nativeQuery = true)
//	List<Flight> findCompanyFlightsByStatus(String companyName
//	                                       , int flightStatus // @Param("flightStatus")
//	);



		//@Transactional
	//@Modifying
	@Query(value = "SELECT f " +
			               "FROM Flight f " +
			               "LEFT JOIN f.company c " +
			               "WHERE c.name = :companyName and f.status = :flightStatus")
	List<Flight> findCompanyFlightsByStatus(String companyName
	                                         , FlightStatus flightStatus
	);
}
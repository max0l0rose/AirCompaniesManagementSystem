package com.example.repository;

import com.example.model.Airplane;
import com.example.model.Company;
import com.example.model.FlightStatus;
import com.example.model.ITestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	Company findByName(String name);

	//	//@Transactional
//	//@Modifying
	@Query(value = "SELECT f.name as 'key', f.id as value \n" +
			               "FROM flight f \n" +
			               "LEFT JOIN company c on c.id = f.company_id \n" +
			               "WHERE c.name = :companyName \n" +
			               "AND f.status = :flightStatus", //:#{#flightStatus.ordinal()}
			nativeQuery = true)
	List<Map.Entry<String, BigInteger>> findCompanyFlightsByStatus(String companyName
	                                       , int flightStatus // @Param("flightStatus")
	);


	//	//@Transactional
//	//@Modifying
//	@Query(value = "SELECT new com.example.model.TestDTO(c.name, f.status) \n" +
//			               "FROM flight f \n" +
//			               "LEFT JOIN company c on c.id = f.company_id \n" +
//			               "WHERE c.name = :companyName")
//	List<TestDTO> findCompanyFlightsByStatus(String companyName
//	                                         //, @Param("flightStatus") FlightStatus flightStatus
//	);
}
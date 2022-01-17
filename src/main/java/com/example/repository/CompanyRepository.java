package com.example.repository;

import com.example.model.Company;
import com.example.model.ITestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CompanyRepository extends JpaRepository<Company, Long> {
//	//@Transactional
//	//@Modifying
	@Query(value = "SELECT c.name as 'key', f.status as value\n" +
			               "FROM flight f\n" +
			               "LEFT JOIN company c on c.id = f.company_id\n" +
			               "WHERE c.name = :companyName", nativeQuery = true)
	List<Map.Entry<String, Integer>> findCompanyFlightsByStatus(String companyName
	                                       //, @Param("flightStatus") FlightStatus flightStatus
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


	//Map.Entry<String, Integer>
}
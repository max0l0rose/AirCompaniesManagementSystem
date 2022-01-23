package com.marshall.crazyairman.repository;

import com.marshall.crazyairman.model.Company;
import com.marshall.crazyairman.model.Flight;
import com.marshall.crazyairman.model.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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
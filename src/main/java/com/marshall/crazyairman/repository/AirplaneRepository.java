package com.marshall.crazyairman.repository;

import com.marshall.crazyairman.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

//@ExposesResourceFor()
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

	Airplane findByName(String name);

//	@Transactional
//	@Modifying
//	@Query("update Airplane a set a.company = ?2 where a.id=?1")
//	int setCompany(long airplaneId, Company company);

	//2
	@Transactional
	@Modifying
	@Query("update Airplane a set a.company.id = ?2 where a.id=?1")
	int setCompany(long airplaneId, long companyId);

//	@Query("insert Airplane a set a.company.id = ?2 where a.id=?1")
//	void createAirplane(Airplane airplane);
}
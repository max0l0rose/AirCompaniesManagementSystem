package com.marshall.crazyairman.repository;

import com.marshall.crazyairman.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
	Airplane findByName(String name);

	// task 2
	@Transactional
	@Modifying
	@Query("update Airplane a set a.company.id = ?2 where a.id=?1")
	int setCompany(long airplaneId, long companyId);
}



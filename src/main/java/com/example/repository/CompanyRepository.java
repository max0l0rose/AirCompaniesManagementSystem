package com.example.repository;

import com.example.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Long> {
//	//@Transactional
//	//@Modifying
//	@Query("update Company c set c.firstName = ?1, e.lastName = ?2 where e.id = ?3")
//	int updateUserNameById(String firstname, String lastname, Integer userId);
}
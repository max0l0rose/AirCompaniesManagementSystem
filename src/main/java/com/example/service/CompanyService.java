package com.example.service;

import com.example.model.Company;
import com.example.model.FlightStatus;
import com.example.repository.CompanyRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CompanyService
{
	final CompanyRepository companyRepository;


	public Optional<Company> findByName(String name) {
		return Optional.ofNullable(companyRepository.findByName(name));
	}


	public Page<Company> getPage(Pageable page) {
		return companyRepository.findAll(page);
	}


	public Optional<Company> findById(long id) {
		return companyRepository.findById(id);
	}


	public Company save(Company airplane) {
		return companyRepository.save(airplane);
	}


	public void delete(long id) {
		companyRepository.deleteById(id);
	}


	public List<Map.Entry<String, BigInteger>> findCompanyFlightsByStatus(String companyName, FlightStatus flightStatus) {
		return companyRepository.findCompanyFlightsByStatus(companyName, flightStatus.ordinal());
	}
}

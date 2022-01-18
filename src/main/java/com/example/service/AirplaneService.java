package com.example.service;

import com.example.model.Airplane;
import com.example.model.Company;
import com.example.repository.AirplaneRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AirplaneService // implements MyService<Airplane>
{
	final AirplaneRepository airplaneRepository;


	public Optional<Airplane> findByName(String name) {
		return Optional.ofNullable(airplaneRepository.findByName(name));
	}


	public Page<Airplane> getPage(Pageable page) {
		return airplaneRepository.findAll(page);
//		try {
//			Statement statement = conn.createStatement();
//			ResultSet rset = statement.executeQuery("SELECT * FROM users");
//
//			while (rset.next()) {
//				Airplane user = new Airplane();
//				user.setId(rset.getInt("id"));
//				user.setName(rset.getString("name"));
//				list.add(user);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
	}


	public Optional<Airplane> findById(long id) {
		return airplaneRepository.findById(id);
	}


	public Airplane save(Airplane airplane) {
		return airplaneRepository.save(airplane);
	}


	public void delete(long id) {
		airplaneRepository.deleteById(id);
	}


	public Airplane assignCompany(Airplane airplane, Company company) {
		airplane.setCompany(company);
		return airplaneRepository.save(airplane);
	}

}

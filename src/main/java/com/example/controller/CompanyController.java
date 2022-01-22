package com.example.controller;

import com.example.model.Company;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.StaleObjectStateException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


// All tasks done through Spring REST


//@RestController
//@RequestMapping("/company")
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Slf4j
//@RestResource()
//public class CompanyController {
//	final CompanyService companyService;
//
//
////	@GetMapping("/findById/{id}")
////	ResponseEntity<Company> getById(
////			@PathVariable long id
////	) {
////		try {
////			Company company = companyService.findById(id).get();
////			return ResponseEntity.ok(company);
////		} catch (NoSuchElementException e) {
////		}
////		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Company());
////	}
////
////
////	@GetMapping("/findByName")
////	ResponseEntity<Company> getByName(
////			@RequestParam String name
////	) {
////		try {
////			Company company = companyService.findByName(name).get();
////			return ResponseEntity.ok(company);
////		} catch (NoSuchElementException e) {
////		}
////		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Company());
////	}
//
//
//
//	@PostMapping()
//	ResponseEntity<Company> create(@RequestBody Company company) {
//		try {
//			//Company company = Company.builder().name(name).build();
//			company = companyService.save(company);
//			return ResponseEntity.ok(company);
//		} catch (DataIntegrityViolationException e) {
//			e.printStackTrace();
//		}
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Company());
//	}
//
//
//	@PatchMapping(value = "/{id}"
//			//, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
//			//, consumes = {MediaType.APPLICATION_JSON_VALUE}
//			)
//	ResponseEntity<Company> patch(@RequestBody Company company, @PathVariable long id) {
//		//Company company = Company.builder().id(id).name(name).build();
//		try {
//			if (id>0)
//				company.setId(id);
//			company = companyService.update(company);
//			return ResponseEntity.ok(company);
//		} catch (DataIntegrityViolationException | StaleObjectStateException | NoSuchElementException e) {
//			e.printStackTrace();
//		}
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Company());
//	}
//
//
//	@DeleteMapping(value = "/delete"
//			//, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
//			//, consumes = {MediaType.APPLICATION_JSON_VALUE}
//	)
//	ResponseEntity<Company> delete(long id) {
//		try {
//			companyService.delete(id);
//			return ResponseEntity.ok(null);
//		} catch (DataIntegrityViolationException | NoSuchElementException e) {
//			e.printStackTrace();
//		}
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//	}
//
//
//	// HATEOAS
//
////	@GetMapping()
////	public EntityModel<Company> qqqq() {
////
////		Company co = Company.builder().name("nnnn").build();
////		co.add(linkTo(methodOn(CompanyController.class).qqqq()).withSelfRel());
////
////		return EntityModel.of(co,
////				linkTo(methodOn(CompanyController.class).qqqq()).withSelfRel()
////		);
////	}
//
//
////	@RequestMapping("/greeting")
////	public HttpEntity<Company> greeting(
////			@RequestParam(value = "name") String name) {
////
////		Company greeting = Company.builder().name(name).build();
////		greeting.add(linkTo(methodOn(CompanyController.class).greeting(name)).withSelfRel());
////
////		return new ResponseEntity<>(greeting, HttpStatus.OK);
////	}
//
//
//}
//


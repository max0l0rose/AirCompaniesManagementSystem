package com.marshall.crazyairman.service;


// not needed coz Spring Rest


//
//@Service
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
//@Transactional
//public class CompanyService
//{
//	final CompanyRepository companyRepository;
//
////	@PersistenceContext
////	final EntityManager em;
//
//	public Optional<Company> findByName(String name) {
//		return Optional.ofNullable(companyRepository.findByName(name));
//	}
//
//
//	public Page<Company> getPage(Pageable page) {
//		return companyRepository.findAll(page);
//	}
//
//
//	public Optional<Company> findById(long id) {
//		return companyRepository.findById(id);
//	}
//
//
//	public Company save(Company company) {
//		return companyRepository.save(company);
//	}
//
//
//	public Company update(Company company) {
//		Company companyOld = findById(company.getId()).get();
//		companyOld.updateFrom(company);
//		//company.setVersion(companyOld.getVersion());
//		//company = em.merge(company);
//		return companyRepository.save(companyOld);
//	}
//
//
//	public void delete(long id) {
//		companyRepository.deleteById(id);
//	}
//
//
//	public List<Flight> findCompanyFlightsByStatus(String companyName,
//	                                               FlightStatus flightStatus) {
//		return companyRepository.findCompanyFlightsByStatus(companyName, flightStatus);
//	}
//}

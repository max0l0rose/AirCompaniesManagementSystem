package com.example;

import com.example.model.Airplane;
import com.example.service.AirplaneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@RunWith(SpringRunner.class)
@SpringBootTest
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
class AirCompaniesManagementSystemApplicationTests {

	@Autowired
	AirplaneService airplaneService;

	@Test
	//@Sql("classpath:test-data.sql")
	void contextLoads() {
		Airplane airplane = airplaneService.findById(1L).get();
		//assertNotNull(airplane);
	}

}

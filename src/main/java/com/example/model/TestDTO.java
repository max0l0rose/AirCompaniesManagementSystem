package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//@SqlResultSetMapping(
//		name = "testDto",
//		entities = {
//				@EntityResult(
//						entityClass = TestDTO.class, // The name of the class
//						fields = {
//								@FieldResult(name = "name", column = "name"),
//								@FieldResult(name = "status", column = "status")
//						}
//				)
//		}
//)

//@NamedNativeQuery(name = "findCompanyFlightsByStatus",
//		query = "SELECT c.name, f.status\n" +
//				        "FROM flight f\n" +
//				        "LEFT JOIN company c on c.id = f.company_id\n" +
//				        "WHERE c.name = :companyName",
//		resultClass = TestDTO.class
//)

public class TestDTO// implements ITestDTO
{
	String name;
	int status;

	@Override
	public String toString() {
		return "TestDTO{" +
				       "name='" + name + '\'' +
				       ", val=" + status +
				       '}';
	}
}


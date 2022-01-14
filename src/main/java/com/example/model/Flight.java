package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Flight extends BaseEntity {

	//@Enumerated(EnumType.STRING)
	FlightStatus status;

	@ManyToOne
	private Company company;

	@ManyToOne(cascade = CascadeType.ALL)
	private Airplane airplane;

	private String departCountry;

	private String destCountry;

	private int distance;

	private LocalTime estimatedFlightTime;

	private OffsetDateTime startedDateTime;
	private OffsetDateTime endedDateTime;
	private OffsetDateTime delayStartedDateTime;

	@Column(columnDefinition="DATETIME(0)")
	private OffsetDateTime createdDateTime;
}


enum FlightStatus {
	ACTIVE, COMPLETED, DELAYED, PENDING
}


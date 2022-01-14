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
	@Column(nullable = false)
	FlightStatus status;

	@ManyToOne
	// I think a flight may be not assigned to a company - nullable
	private Company company;

	// I think a flight may be not assigned to a plane
	// nullable
	@ManyToOne(cascade = CascadeType.ALL)
	private Airplane airplane;

	@Column(nullable = false)
	private String departCountry;

	@Column(nullable = false)
	private String destCountry;

	private int distance;

	@Column(nullable = false)
	private LocalTime estimatedFlightTime;

	@Column(columnDefinition="DATETIME(0)")
	private OffsetDateTime startedDateTime;

	@Column(columnDefinition="DATETIME(0)")
	private OffsetDateTime endedDateTime;

	@Column(columnDefinition="DATETIME(0)")
	private OffsetDateTime delayStartedDateTime;

	@Column(columnDefinition="DATETIME(0)")
	private OffsetDateTime createdDateTime;
}


enum FlightStatus {
	ACTIVE, COMPLETED, DELAYED, PENDING
}


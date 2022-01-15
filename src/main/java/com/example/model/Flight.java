package com.example.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//@DynamicUpdate
public class Flight extends BaseEntity {

	//@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	FlightStatus status = FlightStatus.PENDING;

	@ManyToOne
	// I think a flight may be not assigned to a company - nullable
	Company company;

	// I think a flight may be not assigned to a plane
	// nullable
	@ManyToOne(cascade = CascadeType.ALL)
	Airplane airplane;

	@Column(nullable = false)
	String departCountry = "UA";

	@Column(nullable = false)
	String destCountry = "FRA";

	int distance = 0;

	@Column(nullable = false)
	LocalTime estimatedFlightTime = LocalTime.of(4, 0);

	@Column(columnDefinition="DATETIME(0)")
	OffsetDateTime startedDateTime;

	@Column(columnDefinition="DATETIME(0)")
	OffsetDateTime endedDateTime;

	@Column(columnDefinition="DATETIME(0)")
	OffsetDateTime delayStartedDateTime;

}


enum FlightStatus {
	ACTIVE, COMPLETED, DELAYED, PENDING
}


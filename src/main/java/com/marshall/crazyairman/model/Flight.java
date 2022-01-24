package com.marshall.crazyairman.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DynamicUpdate
public class Flight extends BaseEntity
{
	@Column(nullable = false)
	FlightStatus status = FlightStatus.PENDING;

	// I think a flight may be not assigned to a company - nullable
	@ManyToOne(cascade = CascadeType.ALL) //, fetch = FetchType.LAZY
	Company company;

	// I think a flight may be not assigned to a plane
	@ManyToOne(cascade = CascadeType.ALL) //, fetch = FetchType.LAZY
	Airplane airplane;

	@Column(nullable = false)
	String departCountry = "UA";

	@Column(nullable = false)
	String destCountry = "FRA";

	Integer distance = 0;

	@Column(nullable = false)
	LocalTime estimatedFlightTime = LocalTime.of(5, 0);

	@DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	@Column(columnDefinition="DATETIME(0)")
	OffsetDateTime startedDateTime;

	@Column(columnDefinition="DATETIME(0)")
	OffsetDateTime endedDateTime;

	@Column(columnDefinition="DATETIME(0)")
	OffsetDateTime delayStartedDateTime;


	public int updateFrom(Flight o) {
		int updates = super.updateFrom(o);

		if (o.getStatus() != null) {
			this.setStatus(o.getStatus());
			updates++;
		}
		if (o.getCompany() != null) {
			this.setCompany(o.getCompany());
			updates++;
		}
		if (o.getAirplane() != null) {
			this.setAirplane(o.getAirplane());
			updates++;
		}
		if (o.getDepartCountry() != null) {
			this.setDepartCountry(o.getDepartCountry());
			updates++;
		}
		if (o.getDestCountry() != null) {
			this.setDestCountry(o.getDestCountry());
			updates++;
		}
		if (o.getDistance() != null) {
			this.setDistance(o.getDistance());
			updates++;
		}
		if (o.getEstimatedFlightTime() != null) {
			this.setEstimatedFlightTime(o.getEstimatedFlightTime());
			updates++;
		}
		if (o.getStartedDateTime() != null) {
			this.setStartedDateTime(o.getStartedDateTime());
			updates++;
		}
		if (o.getEndedDateTime() != null) {
			this.setEndedDateTime(o.getEndedDateTime());
			updates++;
		}
		if (o.getDelayStartedDateTime() != null) {
			this.setDelayStartedDateTime(o.getDelayStartedDateTime());
			updates++;
		}
		return updates;
	}

}



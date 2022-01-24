package com.marshall.crazyairman.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DynamicUpdate
public class Airplane extends BaseEntity {
	@Basic(optional = false)
	Integer serial;

	@ManyToOne(cascade = CascadeType.ALL) //, fetch = FetchType.LAZY
	Company company;

	int numberOfFlights;

	int flightDistance;

	@Basic(optional = false)
	Integer fuelCapacity;

	int type;

	LocalDate planeCreated;
}

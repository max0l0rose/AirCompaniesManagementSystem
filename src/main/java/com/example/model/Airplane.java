package com.example.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
//@ToString(of = "name")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Airplane extends BaseEntity {
	int serial;

	//@OneToMany(mappedBy = "beach", fetch = FetchType.EAGER)
	@ManyToOne(cascade = CascadeType.ALL)
	Company company;

	int numberOfFlights;

	int flightDistance;

	int fuelCapacity;

	int type;

	LocalDate planeCreated;
}

package com.example.model;

import lombok.*;
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
public class Airplane extends BaseEntity {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//
//	private String name;

	private int serial;

	//@OneToMany(mappedBy = "beach", fetch = FetchType.EAGER)
	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;

	private int numberOfFlights;

	private int flightDistance;

	private int fuelCapacity;

	private int type;

	private LocalDate planeCreated;
}

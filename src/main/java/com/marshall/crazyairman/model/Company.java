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
public class Company extends BaseEntity
{
	@Basic(optional = false)
	Integer type;

	// the founded date doesn't belong to some timezone ) I think
	LocalDate founded;

	@Override
	public String toString() {
		return "Company{" +
				       "name=" + getName()
				        + '}';
	}

}

package com.example.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@SuperBuilder
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DynamicUpdate
public class Company extends //RepresentationModel<Company>
						BaseEntity
{
//	@Column(nullable = false)
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	Long id;
//
//	String name;

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

	//@Override
	public int updateFrom(Company o) {
		int updates = super.updateFrom(o);

		if (o.getType() != null) {
			this.setType(o.getType());
			updates++;
		}
		if (o.getFounded() != null) {
			this.setFounded(o.getFounded());
			updates++;
		}
		return updates;
	}

}

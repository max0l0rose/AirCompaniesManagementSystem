package com.marshall.crazyairman.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Basic(optional = false)
    String name;

    @Column(columnDefinition="TIMESTAMP(0)")
	@CreatedDate
    Instant created;

    @LastModifiedDate
    @Column(columnDefinition="TIMESTAMP(0)")
    Instant updated;

    @Column(columnDefinition = "integer default 0")
    @Version
    int version;

    public int updateFrom(BaseEntity o) {
        int updates = 0;
        if (o.getCreated() != null) {
            this.setCreated(o.getCreated());
            updates++;
        }
        if (o.getName() != null) {
            this.setName(o.getName());
            updates++;
        }
        return updates;
    }
}

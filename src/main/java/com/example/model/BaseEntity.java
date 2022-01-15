package com.example.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    @Column(columnDefinition="TIMESTAMP(0)")
//	//@CreatedDate
//	@Column(columnDefinition = "TIMESTAMP(0) DEFAULT CURRENT_TIMESTAMP",
//			updatable = false, insertable = false)
//	@Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp // hibernate
//	@UpdateTimestamp
    OffsetDateTime created;

    @LastModifiedDate
    //@UpdateTimestamp
    //@Column(name = "updated")
    Instant updated;

    @Column(columnDefinition = "integer default 0")
    @Version
    int version;


//    @Enumerated(EnumType.ORDINAL)
//    @Column(name = "status")
//    private Status status;
}

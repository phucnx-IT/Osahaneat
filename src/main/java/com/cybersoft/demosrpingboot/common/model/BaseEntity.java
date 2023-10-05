package com.cybersoft.demosrpingboot.common.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    protected String id;
    @CreatedBy
    protected String createBy;
    @LastModifiedBy
    protected String lastModifiedBy;
    @CreatedDate
    protected LocalDateTime createDate;
    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;
}

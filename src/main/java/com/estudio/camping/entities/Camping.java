package com.estudio.camping.entities;

import java.sql.Timestamp;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "camping")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Camping {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "camping")
    private String camping;
    @Column(name = "activo", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean activo = true;
    @CreatedDate
    @Column(name = "createdAt", columnDefinition = "TIMESTAMP (3)")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;
    @LastModifiedDate
    @Column(name = "updatedAt", columnDefinition = "TIMESTAMP (3)")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;
}

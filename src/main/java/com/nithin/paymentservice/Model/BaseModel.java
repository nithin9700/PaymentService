package com.nithin.paymentservice.Model;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;


@MappedSuperclass
@Entity
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
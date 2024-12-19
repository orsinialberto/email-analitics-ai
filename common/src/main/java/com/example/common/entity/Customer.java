package com.example.common.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String customerId;

    @Column(nullable = false)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column
    private String properties;

    @PrePersist
    public void prePersist() {
        final LocalDateTime now = LocalDateTime.now();
        this.createAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

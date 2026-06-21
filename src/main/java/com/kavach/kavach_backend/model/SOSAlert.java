package com.kavach.kavach_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "sos_alerts")
@Data
public class SOSAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userPhone;
    private Double latitude;
    private Double longitude;
    private LocalDateTime triggeredAt;
    private String status;

    @PrePersist
    protected void onCreate() {
        triggeredAt = LocalDateTime.now();
        status = "ACTIVE";
    }
}


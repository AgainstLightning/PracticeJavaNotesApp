package com.practice.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime visitTime;

    public Visit() {
    }

    public void setVisitedAt(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }

    public LocalDateTime getVisitedAt() {
        return this.visitTime;
    }
}


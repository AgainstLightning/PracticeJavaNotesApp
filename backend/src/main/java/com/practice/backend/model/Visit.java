package com.practice.backend.model;

import javax.persistence.Column;
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
  @Column(nullable = false)
  private String ip;
  @Column(nullable = false)
  private LocalDateTime visitTime;

  public Visit() {
  }

  public void setVisitedAt(LocalDateTime visitTime) {
    this.visitTime = visitTime;
  }

  public LocalDateTime getVisitedAt() {
    return this.visitTime;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getIp() {
    return ip;
  }
}

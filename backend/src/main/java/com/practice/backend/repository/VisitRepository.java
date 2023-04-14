package com.practice.backend.repository;

import com.practice.backend.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
  long countByIp(String ip);
  void deleteByIp(String userIp);
}

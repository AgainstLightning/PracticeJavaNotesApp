package com.practice.backend.service;

import com.practice.backend.model.Visit;
import com.practice.backend.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class VisitService {

  @Autowired
  private VisitRepository visitRepository;

  public Visit logVisit(String userIp) {
    Visit visit = new Visit();
    visit.setVisitedAt(LocalDateTime.now());
    visit.setAccountId(userIp);
    return visitRepository.save(visit);
  }

  public long getTotalVisitCount() {
    return visitRepository.count();
  }

  public long getUserVisitCountByIp(String userIp) {
    return visitRepository.countByAccountId(userIp);
  }
  
  @Transactional
  public void deleteVisitsByIp(String ip) {
    visitRepository.deleteByAccountId(ip);
  }
}

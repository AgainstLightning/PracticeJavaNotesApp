package com.practice.backend.service;

import com.practice.backend.model.Visit;
import com.practice.backend.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    public Visit logVisit() {
        Visit visit = new Visit();
        visit.setVisitedAt(LocalDateTime.now());
        return visitRepository.save(visit);
    }
}

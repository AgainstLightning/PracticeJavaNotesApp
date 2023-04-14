package com.practice.backend.controller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.practice.backend.model.Visit;
import com.practice.backend.service.VisitService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class HelloWorldController {
  @Autowired
  private VisitService visitService;

  @GetMapping("/api/hello")
  public HashMap<String, String> HelloWorld(HttpServletRequest request, @RequestParam String accountId) {
    Visit visit = visitService.logVisit(accountId);
    long userVisitCount = visitService.getUserVisitCountByIp(accountId);
    long totalVisitCount = visitService.getTotalVisitCount();

    return new HashMap<>() {
      {
        put("message", "Your visit at " + visit.getVisitedAt() + " has been logged!");
        put("totalVisitCount", String.valueOf(totalVisitCount));
        put("accountId", accountId);
        put("userVisitCount", String.valueOf(userVisitCount));
      }
    };
  }

  @DeleteMapping("/api/visits/clear")
  public ResponseEntity<Void> deleteVisitsByIp(HttpServletRequest request, @RequestParam String accountId) {
    visitService.deleteVisitsByIp(accountId);
    return ResponseEntity.noContent().build();
  }
}

package com.practice.backend.controller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.practice.backend.model.Visit;
import com.practice.backend.service.VisitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HelloWorldController {
  @Autowired
  private VisitService visitService;

  @GetMapping("/api/hello")
  public HashMap<String, String> HelloWorld(HttpServletRequest request) {
    String userIp = request.getRemoteAddr();
    Visit visit = visitService.logVisit(userIp);
    long userVisitCount = visitService.getUserVisitCountByIp(userIp);
    long totalVisitCount = visitService.getTotalVisitCount();

    return new HashMap<>() {
      {
        put("message", "Your visit at " + visit.getVisitedAt() + " has been logged!");
        put("totalVisitCount", String.valueOf(totalVisitCount));
        put("userIp", userIp);
        put("userVisitCount", String.valueOf(userVisitCount));  
      }
    };
  }
}

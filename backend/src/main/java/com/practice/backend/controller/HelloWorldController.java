package com.practice.backend.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public HashMap<String, String> HelloWorld(){
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        var response = new HashMap<String, String>();
        response.put("message", "Hello world! It is currently " + formattedTime + " on the server!");
        return response;
    }
}
package com.Blog_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthChecker {

    @GetMapping("/hello")
    public String hello(){
        return "Application is Running";
    }
}

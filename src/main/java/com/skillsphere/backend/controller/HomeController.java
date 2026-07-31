package com.skillsphere.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "SkillSphere Backend is Running 🚀";
    }

    @GetMapping("/health")
    public String health() {
        return "Application is Healthy ✅";
    }
}
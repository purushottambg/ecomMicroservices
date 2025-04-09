package com.api_gatway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestControl {
    @GetMapping("/test")
    public String testControl(){
        return "Test Successful";
    }
}

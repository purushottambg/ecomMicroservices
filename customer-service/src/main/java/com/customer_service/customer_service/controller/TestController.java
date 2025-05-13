package com.customer_service.customer_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
public class TestController {

    @GetMapping("/greet")
    public String greetCustomer(){
        return "Hello from customer service";
    }
}

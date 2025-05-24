package com.customer_service.controller;

import com.customer_service.dtos.CustomerDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @PostMapping("/create-customer")
    public String createCustomer(@RequestBody CustomerDTO customerDTO){

        return "Customer Has been successfully Created!";
    }
}

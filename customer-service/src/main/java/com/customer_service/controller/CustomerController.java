package com.customer_service.controller;

import com.customer_service.dtos.CustomerDTO;
import com.customer_service.dtos.SignUpDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @PostMapping("/sign-up")
    public String createCustomer(@RequestBody SignUpDTO customerDTO){
        return "Customer Has been successfully Created!";
    }

    @GetMapping("/login")
    public Optional<CustomerDTO> logInCustomer(@RequestBody CustomerDTO customerDTO){

    }
}

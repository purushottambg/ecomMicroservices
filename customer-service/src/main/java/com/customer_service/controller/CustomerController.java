package com.customer_service.controller;

import com.customer_service.dtos.SignUpDTO;
import com.customer_service.entity.CustomerEntity;
import com.customer_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerService customerService;


    @PostMapping("/sign-up")
    public ResponseEntity<?> createCustomer(@RequestBody SignUpDTO signUpDTO){
        Optional<CustomerEntity> savedCustomer = customerService.createUser(signUpDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }
}

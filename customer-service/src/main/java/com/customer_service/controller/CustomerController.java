package com.customer_service.controller;

import com.customer_service.dtos.CustomerDTO;
import com.customer_service.dtos.SignUpDTO;
import com.customer_service.entity.CustomerEntity;
import com.customer_service.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    private ModelMapper modelMapper;
    private CustomerService customerService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> createCustomer(@RequestBody SignUpDTO customerDTO){
        CustomerEntity customerEntityToBeSaved = modelMapper.map(customerDTO, CustomerEntity.class);
        Optional<CustomerEntity> savedCustomer = customerService.createUser(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    @GetMapping("/login")
    public ResponseEntity<?> logInCustomer(@RequestBody CustomerDTO customerDTO){
         Optional<CustomerEntity> foundCustomer = customerService.validateLoginRequest(customerDTO);
         return ResponseEntity.status(HttpStatus.FOUND).body(foundCustomer);
    }
}

package com.customer_service.controller;

import com.customer_service.dtos.ProductDTO;
import com.customer_service.dtos.SignUpDTO;
import com.customer_service.entity.CustomerEntity;
import com.customer_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping(path = "/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customergreetings")
    public String customerGreet(){
        return "Greetings from the customer";
    }

    @GetMapping("/findCustomer/{id}")
    public ResponseEntity<?> findCustomerByID(@RequestParam Long id){
        Optional<SignUpDTO> foundCustomer = customerService.findUser(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(foundCustomer);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> createCustomer(@RequestBody SignUpDTO signUpDTO){
        Optional<CustomerEntity> savedCustomer = customerService.createUser(signUpDTO);
        System.out.println(signUpDTO.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    @GetMapping("/getgreetingsfrominventory")
    public String greetingsFromInventory(){
        return customerService.greetingsFromInventory();
    }

    @GetMapping("/findAllProductsInInventory")
    public List<ProductDTO> findAllProductsInInventory(){
        return customerService.findAllProductsInInventory();
    }

    @GetMapping("/availableStock/{id}")
    public Integer findAllProductsCountInInventory(@RequestParam Long id){
        return customerService.findAllProductsCountInInventory(id);
    }
}

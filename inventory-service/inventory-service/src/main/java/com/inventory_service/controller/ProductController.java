package com.inventory_service.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/products")
    public String showProducts(){
        return "Products";
    }

    @GetMapping("/products/{productID}")
    public String showProductByID(@PathVariable Long productID){
        return "Products By ID "+productID;
    }


}
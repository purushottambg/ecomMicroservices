package com.inventory_service.controller;

import com.inventory_service.dto.ProductDTO;
import com.inventory_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String showProducts(){
        return "Products";
    }

    @GetMapping("/products/{productID}")
    public ResponseEntity<ProductDTO> showProductByID(@PathVariable Long productID){
        return ResponseEntity.ok(productService.findByID(productID));

    }


}
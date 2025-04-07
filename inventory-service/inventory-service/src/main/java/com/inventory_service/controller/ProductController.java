package com.inventory_service.controller;

import com.inventory_service.dto.ProductDTO;
import com.inventory_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor

public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDTO>> showProducts(){
        List<ProductDTO> productDTO = productService.findAll();
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping(value = "/{productID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> showProductByID(@PathVariable Long productID){
        logger.info("Retrieved DTO is: {}",productService.findByID(productID));
        return ResponseEntity.ok(productService.findByID(productID));
    }


}
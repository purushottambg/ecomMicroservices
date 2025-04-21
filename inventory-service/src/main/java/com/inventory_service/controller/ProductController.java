package com.inventory_service.controller;

import com.inventory_service.dto.ItemsDTO;
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
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @GetMapping("/greet")
    public String greet(){
        logger.info("✅ Reached Inventory Controller!");;
        return ("Reached Inventory Controller!");
    }

    @GetMapping("/productname")
    public String getProductNameById(Long id){
        logger.info("Trying return product name for {}th product!",id);
        ProductDTO productDTO  = productService.findByID(id);
        logger.info("Product name is: {}",productDTO.getName());
        return productDTO.getName();
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> showProducts(){
        List<ProductDTO> productDTO = productService.findAll();
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping(value = "/{productID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> showProductByID(@PathVariable Long productID){
        logger.info("Retrieved DTO is: {}",productService.findByID(productID));
        return ResponseEntity.ok(productService.findByID(productID));
    }

    @GetMapping("/availability")
    public String getAvailability(){
        return "Sab kuchh hai apne pass";
    }

    @GetMapping("/availableStock/{productId}")
    private Integer availableStock(@PathVariable Long productId){
        return productService.findByID(productId).getStock();
    }

    @PutMapping("/reduceStock")
    private Double reduceStockOnPurchase(@RequestBody List<ItemsDTO> itemsDTO){
        logger.info("Inventory controller received an order for {} products",itemsDTO.size());
        for (ItemsDTO order: itemsDTO){
            logger.info("id {} and quantity is {}",order.getProductId(), order.getQuantity());
        }
        return productService.reduceStock(itemsDTO);
    }

    @PostMapping("/addStock")
    private List<ProductDTO> addProducts(@RequestBody List<ProductDTO> products){
        for(ProductDTO productDTO: products){
            logger.info("Product ID: {}",productDTO.getProduct_id());
            logger.info("Product Name: {}",productDTO.getName());
            logger.info("Product price: {}",productDTO.getPrice());
            logger.info("Product Stock: {}",productDTO.getStock());
            logger.info("Product Description: {}",productDTO.getDescription());
        }

        return products;
    }

}
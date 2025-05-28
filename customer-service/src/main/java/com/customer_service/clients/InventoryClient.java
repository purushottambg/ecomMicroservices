package com.customer_service.clients;

import com.customer_service.dtos.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "inventory-service" )
public interface InventoryClient {

    @GetMapping("/inventory/greet")
    String getGreetingsFromInventory();

    @GetMapping("/inventory/allproducts")
    List<ProductDTO> findAllProductsInInventory();
}

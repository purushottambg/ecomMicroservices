package com.customer_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "inventory-service" )
public interface InventoryClient {

    @GetMapping("/inventory/greet")
    String findAllProductsInInventory();
}

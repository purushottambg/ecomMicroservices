package com.customer_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "inventory-service", path = "/inventory")
public interface InventoryClient {

    @GetMapping("/greet")
    String findAllProductsInInventory();
}

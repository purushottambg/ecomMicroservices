package com.order_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory-service" )
public interface InventoryInOrderServiceFeignClient {
    @GetMapping("/inventory/greet")
    String greet();

    @GetMapping("/inventory/productname")
    String productName(@RequestParam("id") Long id);
}

package com.order_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "inventory-service" )
public interface InventoryInOrderServiceFeignClient {
    @GetMapping("/inventory/greet")
    String greet();
}

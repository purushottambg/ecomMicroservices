package com.inventory_service.clients;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;

//@FeignClient(name="order-service", path="/orders")
public interface OrderFeignClient {

    @GetMapping("/greetorders")
    String greetorders();

}

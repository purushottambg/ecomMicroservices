package com.order_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
Mention the service details for which this client is.
if you want to have a client that will interact with inventory service
then mention inventory-service name at the beginning
also add api type followed by return type and path
 */

@FeignClient(value = "inventory-service" )
public interface InventoryInOrderServiceFeignClient {
    @GetMapping("/inventory/greet")
    String greet();

    @GetMapping("/inventory/productname")
    String productName(@RequestParam("id") Long id);
}

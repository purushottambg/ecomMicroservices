package com.order_service.clients;

import com.order_service.dto.OrderRequestDTO;
import com.order_service.dto.OrderRequestItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/inventory/availableStock/{productId}")
    Integer getAvailableCount(@PathVariable Long productId);

    @PutMapping("/inventory/reduceStock")
    Double reduceStock(@RequestBody List<OrderRequestItemDTO> orderDTO);
}

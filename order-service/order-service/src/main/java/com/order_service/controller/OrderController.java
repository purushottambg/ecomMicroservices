package com.order_service.controller;

import com.order_service.clients.InventoryInOrderServiceFeignClient;
import com.order_service.dto.OrderRequestDTO;
import java.util.List;
import com.order_service.service.OrdersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@Slf4j
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrdersService ordersService;
    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;
    private final InventoryInOrderServiceFeignClient inventoryInOrderServiceFeignClient;

    @GetMapping("/allorder")
    public List<OrderRequestDTO> getAllOrders(){
        log.info("OrderController: Fetching all the orders in!!");
        return ordersService.getAllOrders();
    }

    @GetMapping("/availability")
    public String getAvailabilityFromInventory(){
        ServiceInstance productService = discoveryClient.getInstances("inventory-service").get(0);
        String response = restClient.get()
                .uri(productService.getUri()+"/inventory/availability")
                .retrieve()
                .body(String.class);
        return response;
    }

    @GetMapping("/getgreeting")
    public String greetOrders(){
        return inventoryInOrderServiceFeignClient.greet();
    }

    @GetMapping("/show-product/{id}")
    public String productNameById(@PathVariable Long id){
        return inventoryInOrderServiceFeignClient.productName(id);
    }

}

package com.order_service.controller;

import com.order_service.dto.OrderRequestDTO;
import java.util.List;
import com.order_service.service.OrdersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrdersService ordersService;

    @GetMapping("/allorder")
    public List<OrderRequestDTO> getAllOrders(){
        log.info("OrderController: Fetching all the orders in!!");
        return ordersService.getAllOrders();
    }

}

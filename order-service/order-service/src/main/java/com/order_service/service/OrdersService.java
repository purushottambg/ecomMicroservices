package com.order_service.service;

import com.order_service.dto.OrderRequestDTO;
import com.order_service.entity.OrdersEntity;
import com.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrdersService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public List<OrderRequestDTO> getAllOrders(){
        log.info("OrderService: Fetching all the orders");

        List<OrderRequestDTO> foundOrders = orderRepository.findAll().stream()
                .map(ordersEntity -> modelMapper.map(ordersEntity, OrderRequestDTO.class))
                .toList();

        List<OrdersEntity> foundOrders1 = orderRepository.findAll();

        log.info("OrderService: Total orders are: {}", foundOrders.size());
        log.info("OrderService: Total order Entities are: {}", foundOrders1.size());

        return foundOrders;
    }
}

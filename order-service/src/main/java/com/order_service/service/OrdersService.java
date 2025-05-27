package com.order_service.service;

import com.order_service.clients.InventoryInOrderServiceFeignClient;
import com.order_service.dto.OrderRequestDTO;
import com.order_service.entity.OrderItemsEntity;
import com.order_service.entity.OrderStatusENum;
import com.order_service.entity.OrdersEntity;
import com.order_service.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import io.github.resilience4j.retry.annotation.Retry;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrdersService {

    private final OrderRepository orderRepository;
    private final InventoryInOrderServiceFeignClient inventoryFeignClient;
    private final ModelMapper modelMapper;

    public List<OrderRequestDTO> getAllOrders(){
        log.info("OrderService: Fetching all the orders");

        List<OrderRequestDTO> orders = orderRepository.findAll().stream()
                .map(entity-> modelMapper.map(entity, OrderRequestDTO.class))
                .toList();

        List<OrdersEntity> foundOrders1 = orderRepository.findAll();

        log.info("OrderService: Total orders are: {}", orders.size());
        log.info("OrderService: Total order Entities are: {}", foundOrders1.size());

        return orders;
    }

    //@Retry(name = "inventoryRetry", fallbackMethod = "handleGreetFallback")
    @RateLimiter(name = "inventoryRateLimiter", fallbackMethod = "inventoryRateLimiter")
    @CircuitBreaker(name = "inventoryCircuitBreaker", fallbackMethod="inventoryRateLimiter")
    public String getGreeting(){
        log.info("Trying to get the greeting message!!");
        return inventoryFeignClient.greet();
    }

    @Retry(name = "inventoryRetry", fallbackMethod = "handleFallback")
    public OrderRequestDTO createNewOrder(OrderRequestDTO orderRequestDTO){

        Double totalCartPrice = inventoryFeignClient.reduceStock(orderRequestDTO.getItems());
        log.info("Count reduced from the inventory and total price is now: {}",totalCartPrice);
        OrdersEntity ordersEntity = modelMapper.map(orderRequestDTO, OrdersEntity.class);
        if(ordersEntity==null){
            log.info("order entity is null");
        }

        for (OrderItemsEntity items: ordersEntity.getOrderItems() ){
            items.setOrdersEntity(ordersEntity);
        }
        ordersEntity.setOrderStatus(OrderStatusENum.CONFIRMED);
        ordersEntity.setPrice(totalCartPrice);
        OrdersEntity savedOrder = orderRepository.save(ordersEntity);

        return modelMapper.map(savedOrder, OrderRequestDTO.class);

    }

    public OrderRequestDTO handleFallback(OrderRequestDTO orderRequestDTO, Throwable throwable){
        log.info("Fallback occurred due to {}", throwable.getMessage());
        return new OrderRequestDTO();
    }

    public String handleGreetFallback(Throwable throwable){
        log.warn("Fallback occurred due to the: {}", throwable.getMessage());
        return "Fallback occurred due to: "+throwable.getMessage();
    }
}

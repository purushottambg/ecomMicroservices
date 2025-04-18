package com.order_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatusENum orderStatus;

    private Double price;
    /*
    Cascade type all is used so changes are reflected in the referring table also
     */
    @OneToMany(mappedBy = "ordersEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemsEntity> orderItems;

}

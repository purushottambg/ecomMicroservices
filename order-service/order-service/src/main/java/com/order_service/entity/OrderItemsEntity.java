package com.order_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orderitems")
public class OrderItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long product_id;

    private Integer quantity;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private OrdersEntity ordersEntity;
}

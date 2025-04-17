package com.order_service.entity;

import com.fasterxml.jackson.databind.node.DoubleNode;
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

    private Double price;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private OrdersEntity ordersEntity;
}

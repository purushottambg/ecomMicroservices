package com.inventory_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long product_id;

    private String Name;

    private Double Value;

    private Integer Stock;

    private String Description;
}

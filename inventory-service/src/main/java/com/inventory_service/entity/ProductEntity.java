package com.inventory_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long product_id;

    private String name;

    private Double price;

    private Integer stock;

    private String description;

}

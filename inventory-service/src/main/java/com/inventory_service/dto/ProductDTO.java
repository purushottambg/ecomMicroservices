package com.inventory_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class ProductDTO {

    private Long product_id;

    private String name;

    private Double price;

    private Integer stock;

    private String description;

}

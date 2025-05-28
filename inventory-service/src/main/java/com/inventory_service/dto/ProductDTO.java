package com.inventory_service.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long product_id;

    private String name;

    private Double price;

    private Integer stock;

    private String description;

}

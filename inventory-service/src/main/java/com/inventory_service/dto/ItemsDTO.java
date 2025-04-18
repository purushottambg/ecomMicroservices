package com.inventory_service.dto;

import lombok.Data;

@Data
public class ItemsDTO {
    private Long id;
    private Long productId;
    private Integer quantity;
}

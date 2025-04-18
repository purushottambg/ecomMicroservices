package com.order_service.dto;

import lombok.Data;

@Data
public class OrderRequestItemDTO {
    private Long id;
    private Long product_id;
    private Integer quantity;
}

package com.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderRequestDTO {
    private Long id;
    private List<OrderRequestItemDTO> items;
    private Integer version;
    private BigDecimal totalPrice;
}

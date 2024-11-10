package com.erkan.order_service.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderLineItemsDto {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}

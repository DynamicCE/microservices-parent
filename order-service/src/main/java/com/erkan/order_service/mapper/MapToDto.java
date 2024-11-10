package com.erkan.order_service.mapper;

import com.erkan.order_service.dto.OrderLineItemsDto;
import com.erkan.order_service.model.OrderLineItems;
import org.springframework.stereotype.Component;

@Component
public class MapToDto {

    public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}

package com.erkan.order_service.service;

import org.springframework.stereotype.Service;
import com.erkan.order_service.dto.OrderRequestDto;
import com.erkan.order_service.model.Order;
import com.erkan.order_service.repository.OrderRepository;

import java.util.UUID;
import java.util.stream.Collectors;
import com.erkan.order_service.model.OrderLineItems;
import com.erkan.order_service.mapper.MapToDto;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private MapToDto mapToDto;

    public OrderService(OrderRepository orderRepository, MapToDto mapToDto) {
        this.orderRepository = orderRepository;
        this.mapToDto = mapToDto;
    }

    public void placeOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequestDto.getOrderLineItemsDtoList()
                .stream()
                .map(mapToDto::mapToDto)
                .collect(Collectors.toList());

        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }

}

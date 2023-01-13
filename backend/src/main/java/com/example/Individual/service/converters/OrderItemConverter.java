package com.example.Individual.service.converters;

import com.example.Individual.dto.entities.OrderItem;
import com.example.Individual.persistence.orderItem.OrderItemEntity;

public class OrderItemConverter {
    private OrderItemConverter(){

    }
    public static OrderItem Convert(OrderItemEntity orderItemEntity){
        return OrderItem.builder()
                .orderNum(orderItemEntity.getOrderNum())
                .product(ProductConverter.Convert(orderItemEntity.getProduct()))
                .quantity(orderItemEntity.getQuantity())
                .build();
    }
}

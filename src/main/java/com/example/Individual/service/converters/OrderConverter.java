package com.example.Individual.service.converters;

import com.example.Individual.dto.entities.Order;
import com.example.Individual.persistence.order.OrderEntity;

public class OrderConverter {
    private OrderConverter(){
    }
    public static Order Convert(OrderEntity orderEntity){
        return Order.builder()
                .clientEmail(orderEntity.getClientEmail())
                .orderNum(orderEntity.getOrderNum())
                .products(orderEntity.getItems())
                .isItActive(orderEntity.isItActive())
                .totalPrice(orderEntity.getTotalPrice())
                .build();
    }
}

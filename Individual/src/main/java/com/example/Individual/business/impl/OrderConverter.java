package com.example.Individual.business.impl;

import com.example.Individual.domain.Order;
import com.example.Individual.domain.persistence.entity.OrderEntity;

public class OrderConverter {
    private OrderConverter(){
    }
    public static Order Convert(OrderEntity orderEntity){
        return Order.builder()
                .products(orderEntity.getProducts())
                .isItActive(orderEntity.isItActive())
                .build();
    }
}

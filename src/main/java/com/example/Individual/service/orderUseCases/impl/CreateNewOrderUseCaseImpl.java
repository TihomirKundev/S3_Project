package com.example.Individual.service.orderUseCases.impl;

import com.example.Individual.persistence.order.OrderEntity;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.persistence.orderItem.OrderItemEntity;
import com.example.Individual.service.orderUseCases.CreateNewOrderUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class CreateNewOrderUseCaseImpl implements CreateNewOrderUseCase {
    private final OrderRepository orderRepository;

    public void createOrder(String email) {
        OrderEntity order = OrderEntity.builder().clientEmail(email).items(new ArrayList<OrderItemEntity>()).isItActive(true).build();
        this.orderRepository.saveAndFlush(order);
    }
}

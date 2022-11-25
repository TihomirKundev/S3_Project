package com.example.Individual.service.orderUseCases.impl;

import com.example.Individual.configuration.security.AccessToken;
import com.example.Individual.configuration.security.Roles;
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
    private final AccessToken accessToken;

    public String createOrder(String email){
        if(!accessToken.getRole().equals(Roles.CLIENT)){
            return "Invalid role!";
        }else if(!accessToken.getEmail().equals(email)){
            return "Trying to access wrong email data!";
        }else {
        OrderEntity order = OrderEntity.builder().clientEmail(email).items(new ArrayList<OrderItemEntity>()).isItActive(true).totalPrice(0.0).build();
        this.orderRepository.saveAndFlush(order);
        return "Success";
        }
    }
}

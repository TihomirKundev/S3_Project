package com.example.Individual.service.orderUseCases.impl;

import com.example.Individual.persistence.order.OrderEntity;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.persistence.orderItem.OrderItemEntity;
import com.example.Individual.service.orderUseCases.PayOrderUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PayOrderUseCaseImpl implements PayOrderUseCase {
    private final OrderRepository orderRepository;

    public void payOrder(String email){
        OrderEntity order = orderRepository.findClientActiveOrder(email);
        double totalPrice = 0.0;
        for (OrderItemEntity i : order.getItems()) {
            totalPrice += i.getQuantity()*i.getProduct().getPrice();
        }
        orderRepository.updateIsItActiveAndTotalPriceByClientEmailAndIsItActiveTrue(totalPrice,email);
    }
}

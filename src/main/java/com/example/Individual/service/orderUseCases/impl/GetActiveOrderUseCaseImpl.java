package com.example.Individual.service.orderUseCases.impl;

import com.example.Individual.dto.entities.Order;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.service.converters.OrderConverter;
import com.example.Individual.service.orderUseCases.GetActiveOrderUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetActiveOrderUseCaseImpl implements GetActiveOrderUseCase {
    private final OrderRepository orderRepository;

    public Order getActiveOrder(String email){
        return OrderConverter.Convert(orderRepository.findClientActiveOrder(email));
    }
}

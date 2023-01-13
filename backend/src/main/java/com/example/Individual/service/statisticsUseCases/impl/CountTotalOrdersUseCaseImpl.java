package com.example.Individual.service.statisticsUseCases.impl;

import com.example.Individual.service.statisticsUseCases.CountTotalOrdersUseCase;
import com.example.Individual.persistence.order.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountTotalOrdersUseCaseImpl implements CountTotalOrdersUseCase {
    private final OrderRepository orderRepository;

    @Override
    public long countOrders() {
        return orderRepository.countByOrderNumNotNull();
    }
}

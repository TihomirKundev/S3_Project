package com.example.Individual.service.statisticsUseCases.impl;

import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.service.statisticsUseCases.CountPaidOrdersUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountPaidOrdersUseCaseImpl implements CountPaidOrdersUseCase {
    private  final OrderRepository orderRepository;
    @Override
    public long countPaidOrders() {
        return orderRepository.countByIsItActiveFalse();
    }
}

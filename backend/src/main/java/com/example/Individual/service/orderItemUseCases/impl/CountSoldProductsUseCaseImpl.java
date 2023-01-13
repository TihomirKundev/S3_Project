package com.example.Individual.service.orderItemUseCases.impl;

import com.example.Individual.persistence.orderItem.OrderItemRepository;
import com.example.Individual.service.orderItemUseCases.CountSoldProductsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountSoldProductsUseCaseImpl implements CountSoldProductsUseCase {
    private  final OrderItemRepository orderItemRepository;
    @Override
    public Long countSoldProducts() {
        return orderItemRepository.countByIdNotNull();
    }
}

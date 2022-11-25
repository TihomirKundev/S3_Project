package com.example.Individual.service.statisticsUseCases.impl;

import com.example.Individual.service.statisticsUseCases.CountProductsUseCase;
import com.example.Individual.persistence.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountProductsUseCaseImpl implements CountProductsUseCase {
    private final ProductRepository productRepository;
    @Override
    public long countProducts() {
        return productRepository.countBySKUNotNull();
    }
}

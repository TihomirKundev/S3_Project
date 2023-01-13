package com.example.Individual.service.statisticsUseCases;

import com.example.Individual.persistence.product.ProductRepository;
import com.example.Individual.service.statisticsUseCases.impl.CountProductsUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountProductsUseCaseTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private CountProductsUseCaseImpl countProductsUseCase;
    @Test
    void countProducts() {
        when(productRepository.countBySKUNotNull()).thenReturn(3L);
        Long result = countProductsUseCase.countProducts();
        assertEquals(3L,result);
    }
}
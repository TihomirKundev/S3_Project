package com.example.Individual.service.statisticsUseCases;

import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.service.statisticsUseCases.impl.CountTotalOrdersUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountTotalOrdersUseCaseTest {
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private CountTotalOrdersUseCaseImpl countTotalOrdersUseCase;
    @Test
    void countOrders() {
        when(orderRepository.countByOrderNumNotNull()).thenReturn(3L);
        Long result = countTotalOrdersUseCase.countOrders();
        assertEquals(3L,result);
    }
}
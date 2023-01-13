package com.example.Individual.service.orderUseCases;

import com.example.Individual.persistence.order.OrderEntity;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.service.orderUseCases.impl.CreateNewOrderUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateNewOrderUseCaseTest {
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private CreateNewOrderUseCaseImpl createNewOrderUseCase;
    @Test
    void createOrder_shouldReturnSuccess() {
        String email = "tihomirkandev@gmail.com";
        createNewOrderUseCase.createOrder(email);
        verify(orderRepository).saveAndFlush(any(OrderEntity.class));
    }
}
package com.example.Individual.service.orderUseCases;

import com.example.Individual.dto.entities.Order;
import com.example.Individual.persistence.order.OrderEntity;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.service.orderUseCases.impl.GetActiveOrderUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GetActiveOrderUseCaseTest {
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private GetActiveOrderUseCaseImpl getActiveOrderUseCase;
    @Test
    void getActiveOrderTest(){
        String email = "tihomirkandev@gmail.com";
        OrderEntity order = OrderEntity.builder()
                .clientEmail(email)
                .orderNum(1)
                .items(new ArrayList<>())
                .isItActive(true)
                .totalPrice(0)
                .build();
        doReturn(order).when(orderRepository).findClientActiveOrder(email);
        Order order1 = getActiveOrderUseCase.getActiveOrder(email);
        assertEquals(order.getOrderNum(),order1.getOrderNum());
        verify(orderRepository).findClientActiveOrder(email);
    }
}
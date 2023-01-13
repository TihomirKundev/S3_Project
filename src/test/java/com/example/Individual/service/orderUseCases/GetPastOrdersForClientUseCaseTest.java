package com.example.Individual.service.orderUseCases;

import com.example.Individual.dto.entities.Order;
import com.example.Individual.dto.responses.GetPastOrdersForClientResponse;
import com.example.Individual.persistence.order.OrderEntity;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.service.converters.OrderConverter;
import com.example.Individual.service.orderUseCases.impl.GetPastOrdersForClientUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetPastOrdersForClientUseCaseTest {
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private GetPastOrdersForClientUseCaseImpl getPastOrdersForClientUseCase;
    @Test
    void getPastOrdersTest() {
        String email = "tihomirkandev@gmail.com";
        OrderEntity orderEntity = OrderEntity.builder()
                .clientEmail(email)
                .orderNum(1)
                .items(new ArrayList<>())
                .isItActive(false)
                .totalPrice(0)
                .build();
        Order order = OrderConverter.Convert(orderEntity);
        when(orderRepository.findByClientEmailAndIsItActiveFalse(email)).thenReturn(List.of(orderEntity));
        GetPastOrdersForClientResponse expectedResponse = GetPastOrdersForClientResponse.builder().orders(List.of(order)).build();
        GetPastOrdersForClientResponse actualResponse = getPastOrdersForClientUseCase.getPastOrders(email);
        assertEquals(expectedResponse,actualResponse);
    }
}
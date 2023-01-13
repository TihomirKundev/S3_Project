package com.example.Individual.service.orderItemUseCases;

import com.example.Individual.dto.responses.GetItemsForActiveOrderResponse;
import com.example.Individual.persistence.orderItem.OrderItemRepository;
import com.example.Individual.service.orderItemUseCases.impl.GetItemsForActiveOrderUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetItemsForActiveOrderUseCaseTest {
    @Mock
    private OrderItemRepository orderItemRepository;
    @InjectMocks
    private GetItemsForActiveOrderUseCaseImpl getItemsForActiveOrderUseCase;
    @Test
    void getItems() {
        GetItemsForActiveOrderResponse expectedResponse = GetItemsForActiveOrderResponse.builder()
                .orderItems(new ArrayList<>())
                .build();
        when(orderItemRepository.findByOrderNum(1)).thenReturn(new ArrayList<>());
        GetItemsForActiveOrderResponse actualResponse = getItemsForActiveOrderUseCase.getItems(1);
        assertEquals(expectedResponse,actualResponse);
    }
}
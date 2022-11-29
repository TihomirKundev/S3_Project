package com.example.Individual.service.orderItemUseCases;

import com.example.Individual.persistence.orderItem.OrderItemRepository;
import com.example.Individual.service.orderItemUseCases.impl.DeleteAllItemsForOrderUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteAllItemsForOrderUseCaseTest {
    @Mock
    private OrderItemRepository orderItemRepository;
    @InjectMocks
    private DeleteAllItemsForOrderUseCaseImpl deleteAllItemsForOrderUseCase;
    @Test
    void deleteItems() {
        deleteAllItemsForOrderUseCase.deleteItems(1);
        verify(orderItemRepository).deleteByOrderNum(1);
    }
}
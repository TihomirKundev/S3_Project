package com.example.Individual.service.orderItemUseCases.impl;

import com.example.Individual.service.orderItemUseCases.DeleteAllItemsForOrderUseCase;
import com.example.Individual.persistence.orderItem.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteAllItemsForOrderUseCaseImpl implements DeleteAllItemsForOrderUseCase {
    private final OrderItemRepository orderItemRepository;
    @Override
    public void deleteItems(int orderNum) {
        orderItemRepository.deleteByOrderNum(orderNum);
    }
}

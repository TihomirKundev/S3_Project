package com.example.Individual.service.orderItemUseCases.impl;

import com.example.Individual.service.orderItemUseCases.RemoveOrderItemUseCase;
import com.example.Individual.dto.requests.ChangeQuantityAndRemoveOrderItemRequest;
import com.example.Individual.persistence.orderItem.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RemoveOrderItemUseCaseImpl implements RemoveOrderItemUseCase {
    private final OrderItemRepository orderItemRepository;
    @Override
    public void removeOrderItem(ChangeQuantityAndRemoveOrderItemRequest request) {
        orderItemRepository.deleteByOrderNumAndProduct(request.getOrderNum(), request.getProduct());
    }
}

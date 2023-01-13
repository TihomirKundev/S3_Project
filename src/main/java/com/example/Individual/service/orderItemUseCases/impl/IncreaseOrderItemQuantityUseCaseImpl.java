package com.example.Individual.service.orderItemUseCases.impl;

import com.example.Individual.service.orderItemUseCases.IncreaseOrderItemQuantityUseCase;
import com.example.Individual.dto.requests.ChangeQuantityAndRemoveOrderItemRequest;
import com.example.Individual.persistence.orderItem.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IncreaseOrderItemQuantityUseCaseImpl implements IncreaseOrderItemQuantityUseCase {
    private final OrderItemRepository orderItemRepository;
    @Override
    public void increaseQuantity(ChangeQuantityAndRemoveOrderItemRequest request) {
        orderItemRepository.updateQuantityByProductIncrease(request.getOrderNum(),request.getProduct());
    }
}

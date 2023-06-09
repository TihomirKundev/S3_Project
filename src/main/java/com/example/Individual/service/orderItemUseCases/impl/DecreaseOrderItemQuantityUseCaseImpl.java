package com.example.Individual.service.orderItemUseCases.impl;

import com.example.Individual.persistence.orderItem.OrderItemEntity;
import com.example.Individual.service.orderItemUseCases.DecreaseOrderItemQuantityUseCase;
import com.example.Individual.dto.requests.ChangeQuantityAndRemoveOrderItemRequest;
import com.example.Individual.persistence.orderItem.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DecreaseOrderItemQuantityUseCaseImpl implements DecreaseOrderItemQuantityUseCase {
    private final OrderItemRepository orderItemRepository;
    @Override
    public void decreaseQuantity(ChangeQuantityAndRemoveOrderItemRequest request) {
        OrderItemEntity orderItem = orderItemRepository.findByOrderNumAndProduct(request.getOrderNum(),request.getProduct());
        if(orderItem.getQuantity() > 1) {
            orderItemRepository.updateQuantityByProductDecrease(request.getOrderNum(), request.getProduct());
        }
    }
}

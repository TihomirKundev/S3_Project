package com.example.Individual.service.orderItemUseCases.impl;

import com.example.Individual.service.orderItemUseCases.AddProductUseCase;
import com.example.Individual.dto.requests.AddProductRequest;
import com.example.Individual.persistence.orderItem.OrderItemRepository;
import com.example.Individual.persistence.orderItem.OrderItemEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddProductUseCaseImpl implements AddProductUseCase {
    private final OrderItemRepository orderItemRepository;
    @Override
    public void addProductToOrder(AddProductRequest addProductRequest) {
        OrderItemEntity orderItem = OrderItemEntity.builder().orderNum(addProductRequest.getOrderNum()).product(addProductRequest.getProduct()).quantity(addProductRequest.getQuantity()).build();
        orderItemRepository.saveAndFlush(orderItem);
    }
}

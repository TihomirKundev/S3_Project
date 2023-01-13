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
        int orderNum = addProductRequest.getOrderNum();
        if(orderItemRepository.existsByOrderNumAndProduct_Sku(orderNum,addProductRequest.getProduct())){
            orderItemRepository.updateQuantityByOrderNumAndProduct(addProductRequest.getQuantity(), addProductRequest.getOrderNum(), addProductRequest.getProduct());
        }else{
        int quantity = addProductRequest.getQuantity();
            OrderItemEntity orderItem = OrderItemEntity.builder().orderNum(orderNum).product(addProductRequest.getProduct()).quantity(quantity).build();
            orderItemRepository.saveAndFlush(orderItem);
        }
    }
}

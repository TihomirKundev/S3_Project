package com.example.Individual.service.orderItemUseCases.impl;

import com.example.Individual.service.converters.OrderItemConverter;
import com.example.Individual.service.orderItemUseCases.GetItemsForActiveOrderUseCase;
import com.example.Individual.dto.responses.GetItemsForActiveOrderResponse;
import com.example.Individual.dto.entities.OrderItem;
import com.example.Individual.persistence.orderItem.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetItemsForActiveOrderUseCaseImpl implements GetItemsForActiveOrderUseCase {
    private final OrderItemRepository orderItemRepository;
    @Override
    public GetItemsForActiveOrderResponse getItems(int orderNum) {
        List<OrderItem> orderItems = orderItemRepository.findByOrderNum(orderNum).stream().map(OrderItemConverter::Convert).toList();
        return GetItemsForActiveOrderResponse.builder().orderItems(orderItems).build();
    }
}

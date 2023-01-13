package com.example.Individual.service.statisticsUseCases.impl;

import com.example.Individual.persistence.order.OrderEntity;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.persistence.orderItem.OrderItemEntity;
import com.example.Individual.persistence.orderItem.OrderItemRepository;
import com.example.Individual.service.statisticsUseCases.CountPriceOfSoldProductsFromSpainUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CountPriceOfSoldProductsFromSpainUseCaseImpl implements CountPriceOfSoldProductsFromSpainUseCase {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    @Override
    public Double countPrice() {
        List<OrderEntity> orders = orderRepository.findByIsItActiveFalse();
        List<Integer> orderNums = new ArrayList<>();
        List<OrderItemEntity> orderItems = new ArrayList<>();
        Double totalSales = 0.0;
        for (OrderEntity order : orders) {
            orderNums.add(order.getOrderNum());
        }
        for (Integer i: orderNums) {
            orderItems = orderItemRepository.findByOrderNumAndProduct_CountryOfOrigin(i, "Spain");
            for (OrderItemEntity o: orderItems) {
                totalSales += o.getQuantity() * o.getProduct().getPrice();
            }
        }
        return totalSales;
    }
}

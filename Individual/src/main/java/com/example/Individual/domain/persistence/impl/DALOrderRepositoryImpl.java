package com.example.Individual.domain.persistence.impl;

import com.example.Individual.domain.persistence.OrderRepository;
import com.example.Individual.domain.persistence.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class DALOrderRepositoryImpl implements OrderRepository {
    private final List<OrderEntity> orders = new ArrayList();
    private static int NEXT_ID = 1;

    public DALOrderRepositoryImpl() {
    }

    public void CreateNewOrder(String email) {
        OrderEntity order = OrderEntity.builder().clientEmail(email).orderNum(NEXT_ID).products(new HashMap()).isItActive(true).totalPrice(0.0).build();
        this.orders.add(order);
        ++NEXT_ID;
    }

    public void PayOrder(String email) {
        OrderEntity order = this.GetActiveOrder(email);
        int position = this.orders.stream().toList().indexOf(order);
        order.setItActive(true);
        this.orders.set(position, order);
        this.CreateNewOrder(email);
    }

    public OrderEntity GetActiveOrder(String email) {
        return (OrderEntity)this.orders.stream().filter((x) -> {
            return x.getClientEmail().equals(email);
        }).filter(OrderEntity::isItActive).findFirst().orElse(null);
    }

    public List<OrderEntity> GetPastOrdersForClient(String email) {
        return this.orders.stream().filter((x) -> {
            return x.getClientEmail().equals(email);
        }).filter((x) -> {
            return !x.isItActive();
        }).toList();
    }
}


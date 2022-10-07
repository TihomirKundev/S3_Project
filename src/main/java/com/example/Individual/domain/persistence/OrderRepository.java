package com.example.Individual.domain.persistence;

import com.example.Individual.domain.persistence.entity.OrderEntity;

import java.util.List;

public interface OrderRepository {
    void CreateNewOrder(String email);

    void PayOrder(String email);

    OrderEntity GetActiveOrder(String email);

    List<OrderEntity> GetPastOrdersForClient(String email);
}

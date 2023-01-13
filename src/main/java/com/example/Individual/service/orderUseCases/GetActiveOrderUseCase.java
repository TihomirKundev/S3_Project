package com.example.Individual.service.orderUseCases;

import com.example.Individual.dto.entities.Order;

public interface GetActiveOrderUseCase {
    Order getActiveOrder(String email);
}

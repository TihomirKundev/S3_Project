package com.example.Individual.service.orderItemUseCases;

import com.example.Individual.dto.requests.ChangeQuantityAndRemoveOrderItemRequest;

public interface IncreaseOrderItemQuantityUseCase {
    void increaseQuantity(ChangeQuantityAndRemoveOrderItemRequest request);
}

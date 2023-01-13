package com.example.Individual.service.orderItemUseCases;

import com.example.Individual.dto.requests.ChangeQuantityAndRemoveOrderItemRequest;

public interface DecreaseOrderItemQuantityUseCase {
    void decreaseQuantity(ChangeQuantityAndRemoveOrderItemRequest request);
}

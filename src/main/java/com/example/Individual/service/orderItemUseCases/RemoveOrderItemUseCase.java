package com.example.Individual.service.orderItemUseCases;

import com.example.Individual.dto.requests.ChangeQuantityAndRemoveOrderItemRequest;

public interface RemoveOrderItemUseCase {
    void removeOrderItem(ChangeQuantityAndRemoveOrderItemRequest request);
}

package com.example.Individual.service.orderItemUseCases;

import com.example.Individual.dto.responses.GetItemsForActiveOrderResponse;

public interface GetItemsForActiveOrderUseCase {
    GetItemsForActiveOrderResponse getItems(int orderNum);
}

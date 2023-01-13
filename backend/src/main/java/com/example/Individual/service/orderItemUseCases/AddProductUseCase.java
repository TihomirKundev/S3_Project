package com.example.Individual.service.orderItemUseCases;

import com.example.Individual.dto.requests.AddProductRequest;

public interface AddProductUseCase {
    void addProductToOrder(AddProductRequest addProductRequest);
}

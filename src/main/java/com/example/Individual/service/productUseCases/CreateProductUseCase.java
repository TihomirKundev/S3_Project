package com.example.Individual.service.productUseCases;

import com.example.Individual.dto.requests.CreateProductRequest;
import com.example.Individual.dto.responses.CreateProductResponse;

public interface CreateProductUseCase {
    CreateProductResponse createProduct(CreateProductRequest request);
}
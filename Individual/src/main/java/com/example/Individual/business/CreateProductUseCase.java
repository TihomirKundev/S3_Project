package com.example.Individual.business;

import com.example.Individual.domain.CreateProductRequest;
import com.example.Individual.domain.CreateProductResponse;

public interface CreateProductUseCase {
    CreateProductResponse createProduct(CreateProductRequest request);
}
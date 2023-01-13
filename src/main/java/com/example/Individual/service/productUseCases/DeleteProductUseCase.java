package com.example.Individual.service.productUseCases;

import com.example.Individual.service.exceptions.InvalidSKUException;

public interface DeleteProductUseCase {
    void deleteProduct(String SKU) throws InvalidSKUException;
}

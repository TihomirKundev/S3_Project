package com.example.Individual.service.productUseCases.impl;

import com.example.Individual.service.exceptions.InvalidSKUException;
import com.example.Individual.service.productUseCases.DeleteProductUseCase;
import com.example.Individual.service.validators.SKUValidator;
import com.example.Individual.persistence.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class DeleteProductUseCaseImpl implements DeleteProductUseCase {
    private final ProductRepository productRepository;
    private final SKUValidator skuValidator;

    @Transactional
    public void deleteProduct(String SKU) throws InvalidSKUException {
        this.skuValidator.validateSKUOnDelete(SKU);
        this.productRepository.deleteBySku(SKU);
    }
}
package com.example.Individual.business.impl;

import com.example.Individual.business.DeleteProductUseCase;
import com.example.Individual.business.SKUValidator;
import com.example.Individual.domain.persistence.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProductUseCaseImpl implements DeleteProductUseCase {
    private final ProductRepository productRepository;
    private final SKUValidator skuValidator;

    public void deleteProduct(String SKU) {
        this.skuValidator.validateSKUOnDelete(SKU);
        this.productRepository.Delete(SKU);
    }
}
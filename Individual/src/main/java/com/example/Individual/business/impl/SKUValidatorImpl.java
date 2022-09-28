package com.example.Individual.business.impl;

import com.example.Individual.business.SKUValidator;
import com.example.Individual.business.exceptions.InvalidSKUException;
import com.example.Individual.domain.persistence.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SKUValidatorImpl implements SKUValidator {
    private final ProductRepository productRepository;

    public void validateSKUOnCreate(String SKU) throws InvalidSKUException {
        if (SKU.isBlank() || this.productRepository.ExistsBySKU(SKU)) {
            throw new InvalidSKUException();
        }
    }

    public void validateSKUOnDelete(String SKU) throws InvalidSKUException {
        if (SKU.isBlank() || !this.productRepository.ExistsBySKU(SKU)) {
            throw new InvalidSKUException();
        }
    }
}

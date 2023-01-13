package com.example.Individual.service.validators.impl;

import com.example.Individual.service.validators.SKUValidator;
import com.example.Individual.service.exceptions.InvalidSKUException;
import com.example.Individual.persistence.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class SKUValidatorImpl implements SKUValidator {
    private final ProductRepository productRepository;

    @Transactional
    public String validateSKUOnCreate(String SKU) throws InvalidSKUException {
        if (SKU.isBlank() || this.productRepository.existsBySku(SKU)) {
            throw new InvalidSKUException();
        }
        return "Success";
    }

    @Transactional
    public String validateSKUOnDelete(String SKU) throws InvalidSKUException {
        if (SKU.isBlank() || !this.productRepository.existsBySku(SKU)) {
            throw new InvalidSKUException();
        }
        return "Success";
    }
}

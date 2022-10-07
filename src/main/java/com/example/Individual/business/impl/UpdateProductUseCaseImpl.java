package com.example.Individual.business.impl;

import com.example.Individual.business.PriceValidator;
import com.example.Individual.business.SKUValidator;
import com.example.Individual.business.UpdateProductUseCase;
import com.example.Individual.domain.UpdateProductRequest;
import com.example.Individual.domain.persistence.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {
    private final ProductRepository productRepository;
    private final PriceValidator priceValidator;
    private final SKUValidator skuValidator;
    @Override
    public void updateProduct(UpdateProductRequest request) {
        this.skuValidator.validateSKUOnDelete(request.getSKU());
        this.priceValidator.validatePrice(request.getPrice());
        this.productRepository.Update(request.getSKU(), request.getDescription(), request.getPrice());
    }
}

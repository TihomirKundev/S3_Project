package com.example.Individual.business.impl;

import com.example.Individual.business.CreateProductUseCase;
import com.example.Individual.business.SKUValidator;
import com.example.Individual.domain.CreateProductRequest;
import com.example.Individual.domain.CreateProductResponse;
import com.example.Individual.domain.persistence.ProductRepository;
import com.example.Individual.domain.persistence.entity.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase {
    private final ProductRepository productRepository;
    private final SKUValidator skuValidator;

    public CreateProductResponse createProduct(CreateProductRequest request) {
        this.skuValidator.validateSKUOnCreate(request.getSKU());
        this.saveNewProduct(request);
        return CreateProductResponse.builder().result("Successfully created product!").build();
    }

    private void saveNewProduct(CreateProductRequest request) {
        ProductEntity productEntity = ProductEntity.builder().SKU(request.getSKU()).category(request.getCategory()).name(request.getName()).description(request.getDescription()).maker(request.getMaker()).countryOfOrigin(request.getCountryOfOrigin()).price(request.getPrice()).weight(request.getWeight()).build();
        this.productRepository.Create(productEntity);
    }
}
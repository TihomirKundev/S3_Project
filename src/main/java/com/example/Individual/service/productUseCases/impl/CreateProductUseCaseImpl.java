package com.example.Individual.service.productUseCases.impl;

import com.example.Individual.service.exceptions.InvalidSKUException;
import com.example.Individual.service.productUseCases.CreateProductUseCase;
import com.example.Individual.service.validators.SKUValidator;
import com.example.Individual.dto.requests.CreateProductRequest;
import com.example.Individual.dto.responses.CreateProductResponse;
import com.example.Individual.persistence.product.ProductRepository;
import com.example.Individual.persistence.product.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase {
    private final ProductRepository productRepository;
    private final SKUValidator skuValidator;

    public CreateProductResponse createProduct(CreateProductRequest request) {
        try{
        this.skuValidator.validateSKUOnCreate(request.getSKU());
        }catch (InvalidSKUException e){
            return CreateProductResponse.builder().result("Failed to create product!").build();
        }
        this.saveNewProduct(request);
        return CreateProductResponse.builder().result("Successfully created product!").build();
    }

    @Transactional
    private void saveNewProduct(CreateProductRequest request) {
        ProductEntity productEntity = ProductEntity.builder().sku(request.getSKU()).category(request.getCategory()).name(request.getName()).description(request.getDescription()).maker(request.getMaker()).countryOfOrigin(request.getCountryOfOrigin()).price(request.getPrice()).weight(request.getWeight()).build();
        this.productRepository.saveAndFlush(productEntity);
    }
}
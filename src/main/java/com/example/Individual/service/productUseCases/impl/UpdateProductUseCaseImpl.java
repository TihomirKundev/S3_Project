package com.example.Individual.service.productUseCases.impl;

import com.example.Individual.service.exceptions.InvalidPriceException;
import com.example.Individual.service.exceptions.InvalidSKUException;
import com.example.Individual.service.validators.PriceValidator;
import com.example.Individual.service.validators.SKUValidator;
import com.example.Individual.service.productUseCases.UpdateProductUseCase;
import com.example.Individual.dto.requests.UpdateProductRequest;
import com.example.Individual.persistence.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {
    private final ProductRepository productRepository;
    private final PriceValidator priceValidator;
    private final SKUValidator skuValidator;
    @Override
    @Transactional
    public String updateProduct(UpdateProductRequest request) {
        try{
            this.skuValidator.validateSKUOnDelete(request.getSKU());
        }catch (InvalidSKUException e){
            return "Invalid SKU!";
        }try{
            this.priceValidator.validatePrice(request.getPrice());
        }catch (InvalidPriceException e){
            return "Invalid price!";
        }
        this.productRepository.updateDescriptionAndPriceBySKU(request.getDescription(), request.getPrice(),request.getSKU());
        return "Success";
    }
}

package com.example.Individual.service.productUseCases;

import com.example.Individual.dto.requests.UpdateProductRequest;
import com.example.Individual.persistence.product.ProductRepository;
import com.example.Individual.service.exceptions.InvalidPriceException;
import com.example.Individual.service.exceptions.InvalidSKUException;
import com.example.Individual.service.productUseCases.impl.UpdateProductUseCaseImpl;
import com.example.Individual.service.validators.PriceValidator;
import com.example.Individual.service.validators.SKUValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateProductUseCaseTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private SKUValidator skuValidator;
    @Mock
    private PriceValidator priceValidator;
    @InjectMocks
    private UpdateProductUseCaseImpl updateProductUseCase;
    @Test
    void updateProduct_shouldReturnSuccess() {
        UpdateProductRequest request = UpdateProductRequest.builder()
                .SKU("KIT_123")
                .description("Test")
                .price(299.99)
                .build();
        when(skuValidator.validateSKUOnDelete(request.getSKU())).thenReturn("Success");
        when(priceValidator.validatePrice(request.getPrice())).thenReturn("Success");
        String actualResult = updateProductUseCase.updateProduct(request);
        String expectedResult = "Success";
        assertEquals(expectedResult,actualResult);
        verify(skuValidator).validateSKUOnDelete(request.getSKU());
        verify(priceValidator).validatePrice(request.getPrice());
        verify(productRepository).updateDescriptionAndPriceBySKU(request.getDescription(),request.getPrice(),request.getSKU());
    }
    @Test
    void updateProduct_shouldReturnInvalidSKU() {
        UpdateProductRequest request = UpdateProductRequest.builder()
                .SKU("KIT_123")
                .description("Test")
                .price(299.99)
                .build();
        when(skuValidator.validateSKUOnDelete(request.getSKU())).thenThrow(InvalidSKUException.class);
        String actualResult = updateProductUseCase.updateProduct(request);
        String expectedResult = "Invalid SKU!";
        assertEquals(expectedResult,actualResult);
        verify(skuValidator).validateSKUOnDelete(request.getSKU());
    }
    @Test
    void updateProduct_shouldReturnInvalidPrice() {
        UpdateProductRequest request = UpdateProductRequest.builder()
                .SKU("KIT_123")
                .description("Test")
                .price(299.99)
                .build();
        when(skuValidator.validateSKUOnDelete(request.getSKU())).thenReturn("Success");
        when(priceValidator.validatePrice(request.getPrice())).thenThrow(InvalidPriceException.class);
        String actualResult = updateProductUseCase.updateProduct(request);
        String expectedResult = "Invalid price!";
        assertEquals(expectedResult,actualResult);
        verify(skuValidator).validateSKUOnDelete(request.getSKU());
        verify(priceValidator).validatePrice(request.getPrice());
    }
}
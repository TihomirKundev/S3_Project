package com.example.Individual.service.productUseCases;

import com.example.Individual.dto.requests.CreateProductRequest;
import com.example.Individual.persistence.product.ProductRepository;
import com.example.Individual.service.exceptions.InvalidSKUException;
import com.example.Individual.service.productUseCases.impl.CreateProductUseCaseImpl;
import com.example.Individual.service.validators.SKUValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private SKUValidator skuValidator;
    @InjectMocks
    private CreateProductUseCaseImpl createProductUseCase;
    @Test
    void createProduct_shouldReturnSuccess() {
        CreateProductRequest request = CreateProductRequest.builder()
                .SKU("KIT_123")
                .category("Kitchen")
                .name("Sink")
                .description("Test")
                .maker("IKEA")
                .countryOfOrigin("Belgium")
                .price(299.99)
                .weight(21.34)
                .build();
        when(skuValidator.validateSKUOnCreate(request.getSKU())).thenReturn("Success");
        String expectedMessage = "Successfully created product!";
        String actualMessage = createProductUseCase.createProduct(request).getResult();
        assertEquals(expectedMessage,actualMessage);
        verify(skuValidator).validateSKUOnCreate(request.getSKU());
    }
    @Test
    void createProduct_ShouldThrowInvalidSKUException(){
        CreateProductRequest request = CreateProductRequest.builder()
                .SKU("KIT_123")
                .category("Kitchen")
                .name("Sink")
                .description("Test")
                .maker("IKEA")
                .countryOfOrigin("Belgium")
                .price(299.99)
                .weight(21.34)
                .build();
        when(skuValidator.validateSKUOnCreate(request.getSKU())).thenThrow(InvalidSKUException.class);
        String expectedMessage = "Failed to create product!";
        String actualMessage = createProductUseCase.createProduct(request).getResult();
        assertEquals(expectedMessage,actualMessage);
        verify(skuValidator).validateSKUOnCreate(request.getSKU());
    }
}
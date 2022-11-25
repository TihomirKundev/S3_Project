package com.example.Individual.service.productUseCases;

import com.example.Individual.persistence.product.ProductRepository;
import com.example.Individual.service.exceptions.InvalidSKUException;
import com.example.Individual.service.productUseCases.impl.DeleteProductUseCaseImpl;
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
class DeleteProductUseCaseTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private SKUValidator skuValidator;
    @InjectMocks
    private DeleteProductUseCaseImpl deleteProductUseCase;

    @Test
    void deleteProduct_ShouldReturnSuccess() {
        String SKU = "KIT_123";
        when(skuValidator.validateSKUOnDelete(SKU)).thenReturn("Success");
        deleteProductUseCase.deleteProduct(SKU);
        verify(skuValidator).validateSKUOnDelete(SKU);
        verify(productRepository).deleteBySku(SKU);
    }
    @Test
    void deleteProduct_ShouldThrowInvalidSKUException(){
        String SKU = "KIT_123";
        when(skuValidator.validateSKUOnDelete(SKU)).thenThrow(InvalidSKUException.class);
        Exception exception = assertThrows(InvalidSKUException.class, () -> {
            deleteProductUseCase.deleteProduct(SKU);
        });
        assertEquals(InvalidSKUException.class, exception.getClass());
        verify(skuValidator).validateSKUOnDelete(SKU);
    }
}
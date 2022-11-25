package com.example.Individual.service.productUseCases;

import com.example.Individual.dto.entities.Product;
import com.example.Individual.dto.responses.GetAllProductsResponse;
import com.example.Individual.persistence.product.ProductEntity;
import com.example.Individual.persistence.product.ProductRepository;
import com.example.Individual.service.productUseCases.impl.GetProductsUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetProductsUseCaseTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private GetProductsUseCaseImpl getProductsUseCase;

    @Test
    void getProducts() {
        Product product1 = Product.builder()
                .SKU("KIT_123")
                .category("Kitchen")
                .name("Sink")
                .description("Test")
                .maker("IKEA")
                .countryOfOrigin("Belgium")
                .price(299.99)
                .weight(21.34)
                .build();
        ProductEntity product2 = ProductEntity.builder()
                .sku("KIT_123")
                .category("Kitchen")
                .name("Sink")
                .description("Test")
                .maker("IKEA")
                .countryOfOrigin("Belgium")
                .price(299.99)
                .weight(21.34)
                .build();
        GetAllProductsResponse expectedResponse = GetAllProductsResponse.builder().products(List.of(product1)).build();
        when(productRepository.findAll()).thenReturn(List.of(product2));
        GetAllProductsResponse actualResponse = getProductsUseCase.getProducts();
        assertEquals(expectedResponse,actualResponse);
        verify(productRepository).findAll();
    }
}
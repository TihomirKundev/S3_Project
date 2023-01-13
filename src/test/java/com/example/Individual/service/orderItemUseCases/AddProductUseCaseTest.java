package com.example.Individual.service.orderItemUseCases;

import com.example.Individual.dto.requests.AddProductRequest;
import com.example.Individual.persistence.orderItem.OrderItemEntity;
import com.example.Individual.persistence.orderItem.OrderItemRepository;
import com.example.Individual.persistence.product.ProductEntity;
import com.example.Individual.service.orderItemUseCases.impl.AddProductUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AddProductUseCaseTest {
    @Mock
    private OrderItemRepository orderItemRepository;
    @InjectMocks
    private AddProductUseCaseImpl addProductUseCase;
    @Test
    void addProductToOrder() {
        ProductEntity product = ProductEntity.builder()
                .sku("KIT_123")
                .category("Kitchen")
                .name("Sink")
                .description("Test")
                .maker("IKEA")
                .countryOfOrigin("Belgium")
                .weight(23.14)
                .price(299.99)
                .build();
        AddProductRequest addProductRequest = AddProductRequest.builder()
                .orderNum(1)
                .product(product)
                .quantity(1)
                .build();
        addProductUseCase.addProductToOrder(addProductRequest);
        verify(orderItemRepository).saveAndFlush(isA(OrderItemEntity.class));
    }
}
package com.example.Individual.service.orderItemUseCases;

import com.example.Individual.dto.requests.ChangeQuantityAndRemoveOrderItemRequest;
import com.example.Individual.persistence.orderItem.OrderItemRepository;
import com.example.Individual.persistence.product.ProductEntity;
import com.example.Individual.service.orderItemUseCases.impl.DecreaseOrderItemQuantityUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DecreaseOrderItemQuantityUseCaseTest {
    @Mock
    private OrderItemRepository orderItemRepository;
    @InjectMocks
    private DecreaseOrderItemQuantityUseCaseImpl decreaseOrderItemQuantityUseCase;
    @Test
    void decreaseQuantity() {
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
        ChangeQuantityAndRemoveOrderItemRequest request = ChangeQuantityAndRemoveOrderItemRequest.builder()
                .orderNum(1)
                .product(product)
                .build();
        decreaseOrderItemQuantityUseCase.decreaseQuantity(request);
        verify(orderItemRepository).updateQuantityByProductDecrease(request.getOrderNum(),request.getProduct());
    }
}
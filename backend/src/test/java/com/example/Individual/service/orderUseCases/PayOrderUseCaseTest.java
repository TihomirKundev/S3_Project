package com.example.Individual.service.orderUseCases;

import com.example.Individual.persistence.order.OrderEntity;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.persistence.orderItem.OrderItemEntity;
import com.example.Individual.persistence.product.ProductEntity;
import com.example.Individual.service.orderUseCases.impl.PayOrderUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PayOrderUseCaseTest {
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private PayOrderUseCaseImpl payOrderUseCase;

    @Test
    void payOrder_shouldReturnSuccess() {
        String email = "tihomirkandev@gmail.com";
        ProductEntity product = ProductEntity.builder()
                .sku("BAT_123")
                .category("Bathroom")
                .name("Sink")
                .description("Test")
                .maker("Ikea")
                .countryOfOrigin("Belgium")
                .price(27.27)
                .weight(11.11)
                .build();
        OrderItemEntity orderItem = OrderItemEntity.builder()
                .id(1)
                .orderNum(1)
                .product(product)
                .quantity(1)
                .build();
        OrderEntity order = OrderEntity.builder()
                .clientEmail(email)
                .orderNum(1)
                .items(List.of(orderItem))
                .isItActive(true)
                .totalPrice(0)
                .build();
        when(orderRepository.findClientActiveOrder(email)).thenReturn(order);
        payOrderUseCase.payOrder(email);
        verify(orderRepository).updateIsItActiveAndTotalPriceByClientEmailAndIsItActiveTrue(27.27,email);
    }

}
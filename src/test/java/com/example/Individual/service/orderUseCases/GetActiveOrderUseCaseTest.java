package com.example.Individual.service.orderUseCases;

import com.example.Individual.configuration.security.AccessToken;
import com.example.Individual.configuration.security.Roles;
import com.example.Individual.dto.entities.Order;
import com.example.Individual.persistence.order.OrderEntity;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.service.converters.OrderConverter;
import com.example.Individual.service.orderUseCases.impl.GetActiveOrderUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetActiveOrderUseCaseTest {
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private AccessToken accessToken;
    @Mock
    private OrderConverter orderConverter;
    @InjectMocks
    private GetActiveOrderUseCaseImpl getActiveOrderUseCase;
    @Test
    void getActiveOrder_shouldBeSuccess() {
        String email = "tihomirkandev@gmail.com";
        OrderEntity order = OrderEntity.builder()
                .clientEmail(email)
                .orderNum(1)
                .items(new ArrayList<>())
                .isItActive(true)
                .totalPrice(0)
                .build();
        Order order1 = Order.builder()
                .clientEmail(email)
                .orderNum(1)
                .products(new ArrayList<>())
                .isItActive(true)
                .totalPrice(0)
                .build();
        when(accessToken.getRole()).thenReturn(Roles.CLIENT);
        when(accessToken.getEmail()).thenReturn(email);
        //TODO don't know how to fix it
        when(orderRepository.findByClientEmailAndIsItActiveTrue(email).get()).thenReturn(order);
        when(OrderConverter.Convert(isA(OrderEntity.class))).thenReturn(order1);
        Order order2 = getActiveOrderUseCase.getActiveOrder(email);
        assertNotNull(order1);
        verify(accessToken).getRole();
        verify(accessToken).getEmail();
    }
    @Test
    void getActiveOrder_shouldReturnNullForReasonRole(){
        String email = "tihomirkandev@gmail.com";
        when(accessToken.getRole()).thenReturn(Roles.MANAGER);
        Order nullOrder = getActiveOrderUseCase.getActiveOrder(email);
        assertNull(nullOrder);
        verify(accessToken).getRole();
    }
    @Test
    void getActiveOrder_shouldReturnNullForReasonEmail(){
        String email = "tihomirkandev@gmail.com";
        when(accessToken.getRole()).thenReturn(Roles.CLIENT);
        when(accessToken.getEmail()).thenReturn("test@gmail.com");
        Order nullOrder = getActiveOrderUseCase.getActiveOrder(email);
        assertNull(nullOrder);
        verify(accessToken).getRole();
        verify(accessToken).getEmail();
    }
}
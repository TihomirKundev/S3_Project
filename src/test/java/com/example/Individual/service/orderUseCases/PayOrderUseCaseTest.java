package com.example.Individual.service.orderUseCases;

import com.example.Individual.configuration.security.AccessToken;
import com.example.Individual.configuration.security.Roles;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.service.orderUseCases.impl.PayOrderUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PayOrderUseCaseTest {
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private AccessToken accessToken;
    @InjectMocks
    private PayOrderUseCaseImpl payOrderUseCase;

    @Test
    void payOrder_shouldReturnSuccess() {
        String email = "tihomirkandev@gmail.com";
        when(accessToken.getRole()).thenReturn(Roles.CLIENT);
        when(accessToken.getEmail()).thenReturn(email);
        String expectedResult = "Success";
        String actualResult = payOrderUseCase.payOrder(email);
        assertEquals(expectedResult,actualResult);
        verify(accessToken).getRole();
        verify(accessToken).getEmail();
    }
    @Test
    void getPastOrders_shouldReturnInvalidRole() {
        String email = "tihomirkandev@gmail.com";
        when(accessToken.getRole()).thenReturn(Roles.MANAGER);
        String expectedResult = "Invalid role!";
        String actualResult = payOrderUseCase.payOrder(email);
        assertEquals(expectedResult,actualResult);
        verify(accessToken).getRole();
    }
    @Test
    void getPastOrders_shouldReturnInvalidCredentials() {
        String email = "tihomirkandev@gmail.com";
        when(accessToken.getRole()).thenReturn(Roles.CLIENT);
        when(accessToken.getEmail()).thenReturn("test@gmail.com");
        String expectedResult = "Trying to access wrong email data!";
        String actualResult = payOrderUseCase.payOrder(email);
        assertEquals(expectedResult,actualResult);
        verify(accessToken).getRole();
        verify(accessToken).getEmail();
    }
}
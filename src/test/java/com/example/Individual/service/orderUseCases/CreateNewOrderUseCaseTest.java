package com.example.Individual.service.orderUseCases;

import com.example.Individual.configuration.security.AccessToken;
import com.example.Individual.configuration.security.Roles;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.service.orderUseCases.impl.CreateNewOrderUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateNewOrderUseCaseTest {
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private AccessToken accessToken;
    @InjectMocks
    private CreateNewOrderUseCaseImpl createNewOrderUseCase;
    @Test
    void createOrder_shouldReturnSuccess() {
        String email = "tihomirkandev@gmail.com";
        accessToken.setEmail(email);
        accessToken.setRole(Roles.CLIENT);
        when(accessToken.getRole()).thenReturn(Roles.CLIENT);
        when(accessToken.getEmail()).thenReturn(email);
        String expectedResult = "Success";
        String actualResult = createNewOrderUseCase.createOrder(email);
        assertEquals(expectedResult,actualResult);
        verify(accessToken).getRole();
        verify(accessToken).getEmail();
    }
    @Test
    void createOrder_shouldReturnInvalidRole() {
        String email = "tihomirkandev@gmail.com";
        accessToken.setEmail(email);
        accessToken.setRole(Roles.MANAGER);
        when(accessToken.getRole()).thenReturn(Roles.MANAGER);
        String expectedResult = "Invalid role!";
        String actualResult = createNewOrderUseCase.createOrder(email);
        assertEquals(expectedResult,actualResult);
        verify(accessToken).getRole();
    }
    @Test
    void createOrder_shouldReturnInvalidEmail() {
        String email = "tihomirkandev@gmail.com";
        accessToken.setEmail(email);
        accessToken.setRole(Roles.MANAGER);
        when(accessToken.getRole()).thenReturn(Roles.CLIENT);
        when(accessToken.getEmail()).thenReturn("test@gmail.com");
        String expectedResult = "Trying to access wrong email data!";
        String actualResult = createNewOrderUseCase.createOrder(email);
        assertEquals(expectedResult,actualResult);
        verify(accessToken).getRole();
        verify(accessToken).getEmail();
    }
}
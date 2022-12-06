package com.example.Individual.service.orderUseCases;

import com.example.Individual.configuration.security.AccessToken;
import com.example.Individual.configuration.security.Roles;
import com.example.Individual.dto.entities.Order;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.service.converters.OrderConverter;
import com.example.Individual.service.orderUseCases.impl.GetActiveOrderUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNull;
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
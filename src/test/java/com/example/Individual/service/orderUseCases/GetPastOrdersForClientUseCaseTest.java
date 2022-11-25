package com.example.Individual.service.orderUseCases;

import com.example.Individual.configuration.security.AccessToken;
import com.example.Individual.configuration.security.Roles;
import com.example.Individual.dto.responses.GetPastOrdersForClientResponse;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.service.orderUseCases.impl.GetPastOrdersForClientUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetPastOrdersForClientUseCaseTest {
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private AccessToken accessToken;
    @InjectMocks
    private GetPastOrdersForClientUseCaseImpl getPastOrdersForClientUseCase;
    @Test
    void getPastOrders_shouldPass() {
        String email = "tihomirkandev@gmail.com";
        when(accessToken.getRole()).thenReturn(Roles.CLIENT);
        when(accessToken.getEmail()).thenReturn(email);
        GetPastOrdersForClientResponse response = getPastOrdersForClientUseCase.getPastOrders(email);
        assertNotNull(response.getOrders());
        verify(accessToken).getRole();
        verify(accessToken).getEmail();
        verify(orderRepository).findByClientEmailAndIsItActiveFalse(email);
    }
    @Test
    void getPastOrders_shouldReturnNullForWrongRole() {
        String email = "tihomirkandev@gmail.com";
        when(accessToken.getRole()).thenReturn(Roles.MANAGER);
        GetPastOrdersForClientResponse response = getPastOrdersForClientUseCase.getPastOrders(email);
        assertNull(response.getOrders());
        verify(accessToken).getRole();
    }
    @Test
    void getPastOrders_shouldReturnNullForWrongEmail() {
        String email = "tihomirkandev@gmail.com";
        when(accessToken.getRole()).thenReturn(Roles.CLIENT);
        when(accessToken.getEmail()).thenReturn("test@gmail.com");
        GetPastOrdersForClientResponse response = getPastOrdersForClientUseCase.getPastOrders(email);
        assertNull(response.getOrders());
        verify(accessToken).getRole();
        verify(accessToken).getEmail();
    }
}
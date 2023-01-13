package com.example.Individual.service.statisticsUseCases;

import com.example.Individual.persistence.client.ClientRepository;
import com.example.Individual.service.statisticsUseCases.impl.TotalRegisteredUsersUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TotalRegisteredUsersUseCaseTest {
    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private TotalRegisteredUsersUseCaseImpl totalRegisteredUsersUseCase;
    @Test
    void totalCustomers() {
        when(clientRepository.countByEmailNotNull()).thenReturn(3L);
        Long result = totalRegisteredUsersUseCase.totalCustomers();
        assertEquals(3L,result);
    }
}
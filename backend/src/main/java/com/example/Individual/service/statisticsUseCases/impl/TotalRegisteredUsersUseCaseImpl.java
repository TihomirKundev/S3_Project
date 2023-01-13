package com.example.Individual.service.statisticsUseCases.impl;

import com.example.Individual.service.statisticsUseCases.TotalRegisteredUsersUseCase;
import com.example.Individual.persistence.client.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TotalRegisteredUsersUseCaseImpl implements TotalRegisteredUsersUseCase {
    private final ClientRepository clientRepository;

    @Override
    public long totalCustomers() {
        return clientRepository.countByEmailNotNull();
    }
}

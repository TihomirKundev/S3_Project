package com.example.Individual.service.orderUseCases;

import com.example.Individual.dto.responses.GetPastOrdersForClientResponse;

public interface GetPastOrdersForClientUseCase {
    GetPastOrdersForClientResponse getPastOrders(String email);
}

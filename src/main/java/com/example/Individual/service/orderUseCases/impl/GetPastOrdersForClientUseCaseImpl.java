package com.example.Individual.service.orderUseCases.impl;

import com.example.Individual.configuration.security.AccessToken;
import com.example.Individual.configuration.security.Roles;
import com.example.Individual.dto.entities.Order;
import com.example.Individual.dto.responses.GetPastOrdersForClientResponse;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.service.converters.OrderConverter;
import com.example.Individual.service.orderUseCases.GetPastOrdersForClientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetPastOrdersForClientUseCaseImpl implements GetPastOrdersForClientUseCase {
    private final OrderRepository orderRepository;
    private final AccessToken accessToken;

    public GetPastOrdersForClientResponse getPastOrders(String email){
        if(!accessToken.getRole().equals(Roles.CLIENT)){
            return GetPastOrdersForClientResponse.builder().orders(null).build();
        }else if(!accessToken.getEmail().equals(email)){
            return GetPastOrdersForClientResponse.builder().orders(null).build();
        }else {
            List<Order> list = orderRepository.findByClientEmailAndIsItActiveFalse(email).stream().map(OrderConverter::Convert).toList();
            return GetPastOrdersForClientResponse.builder().orders(list).build();
        }
    }
}

package com.example.Individual.service.orderUseCases.impl;

import com.example.Individual.configuration.security.AccessToken;
import com.example.Individual.configuration.security.Roles;
import com.example.Individual.dto.entities.Order;
import com.example.Individual.persistence.order.OrderRepository;
import com.example.Individual.service.converters.OrderConverter;
import com.example.Individual.service.orderUseCases.GetActiveOrderUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetActiveOrderUseCaseImpl implements GetActiveOrderUseCase {
    private final OrderRepository orderRepository;
    private final AccessToken accessToken;


    public Order getActiveOrder(String email){
        if(!accessToken.getRole().equals(Roles.CLIENT)){
            return null;
        }else if(!accessToken.getEmail().equals(email)){
            return null;
        }else {
            //noinspection OptionalGetWithoutIsPresent
            return OrderConverter.Convert(orderRepository.findByClientEmailAndIsItActiveTrue(email).get());
        }
    }
}

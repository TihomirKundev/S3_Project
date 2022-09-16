package com.example.Individual.business.impl;

import com.example.Individual.domain.Client;
import com.example.Individual.domain.persistence.entity.ClientEntity;

public class ClientConverter {
    private ClientConverter(){
    }
    public static Client Convert(ClientEntity clientEntity){
        return Client.builder()
                .firstName(clientEntity.getFirstName())
                .lastName(clientEntity.getLastName())
                .email(clientEntity.getEmail())
                .password(clientEntity.getPassword())
                .orders(clientEntity.getOrders())
                .build();
    }
}

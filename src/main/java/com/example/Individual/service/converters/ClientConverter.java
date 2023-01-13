package com.example.Individual.service.converters;

import com.example.Individual.dto.entities.Client;
import com.example.Individual.persistence.client.ClientEntity;

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

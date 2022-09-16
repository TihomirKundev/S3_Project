package com.example.Individual.domain.persistence.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<OrderEntity> orders;
}

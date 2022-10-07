package com.example.Individual.domain;

import com.example.Individual.domain.persistence.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<OrderEntity> orders;
}

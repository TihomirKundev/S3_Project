package com.example.Individual.dto.entities;

import com.example.Individual.persistence.order.OrderEntity;
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

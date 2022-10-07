package com.example.Individual.domain.persistence.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class OrderEntity {
    String clientEmail;
    int orderNum;
    Map<ProductEntity, Integer> products;
    boolean isItActive;
    double totalPrice;
}

package com.example.Individual.domain.persistence.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class OrderEntity {
    Map<ProductEntity, Integer> products;
    private boolean isItActive;
}

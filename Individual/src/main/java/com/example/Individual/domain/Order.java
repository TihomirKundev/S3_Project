package com.example.Individual.domain;

import com.example.Individual.domain.persistence.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    Map<ProductEntity, Integer> products;
    private boolean isItActive;
}

package com.example.Individual.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String SKU;
    private String category;
    private String name;
    private String description;
    private String maker;
    private String countryOfOrigin;
    private Double price;
    private Double weight;
}

package com.example.Individual.domain.persistence.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductEntity {
    private String SKU;
    private String category;
    private String name;
    private String description;
    private String maker;
    private String countryOfOrigin;
    private Double price;
    private Double weight;
}

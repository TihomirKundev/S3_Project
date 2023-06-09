package com.example.Individual.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    @NotBlank
    private String sku;
    @NotBlank
    private String category;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String maker;
    @NotBlank
    private String countryOfOrigin;
    @Min(0)
    private Double price;
    @Min(0)
    private Double weight;
}

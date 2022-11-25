package com.example.Individual.dto.responses;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CreateProductResponse {
    @NotBlank
    private String result;
}

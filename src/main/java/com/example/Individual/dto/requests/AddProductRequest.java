package com.example.Individual.dto.requests;

import com.example.Individual.persistence.product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequest {
    @NotNull
    private int orderNum;
    @NotNull
    private ProductEntity product;
    @NotNull
    private int quantity;
}

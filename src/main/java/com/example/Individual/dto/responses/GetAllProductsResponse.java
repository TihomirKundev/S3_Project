package com.example.Individual.dto.responses;

import com.example.Individual.dto.entities.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class GetAllProductsResponse {
    private List<Product> products;
}

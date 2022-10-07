package com.example.Individual.business.impl;

import com.example.Individual.business.GetProductsUseCase;
import com.example.Individual.domain.GetAllProductsResponse;
import com.example.Individual.domain.Product;
import com.example.Individual.domain.persistence.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetProductsUseCaseImpl implements GetProductsUseCase {
    private final ProductRepository productRepository;

    public GetAllProductsResponse getProducts() {
        List<Product> productList = this.productRepository.GetAll().stream().map(ProductConverter::Convert).toList();
        return GetAllProductsResponse.builder().products(productList).build();
    }
}

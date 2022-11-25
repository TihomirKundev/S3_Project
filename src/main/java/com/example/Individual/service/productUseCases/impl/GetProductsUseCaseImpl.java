package com.example.Individual.service.productUseCases.impl;

import com.example.Individual.service.converters.ProductConverter;
import com.example.Individual.service.productUseCases.GetProductsUseCase;
import com.example.Individual.dto.responses.GetAllProductsResponse;
import com.example.Individual.dto.entities.Product;
import com.example.Individual.persistence.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class GetProductsUseCaseImpl implements GetProductsUseCase {
    private final ProductRepository productRepository;

    @Transactional
    public GetAllProductsResponse getProducts() {
        List<Product> productList = this.productRepository.findAll().stream().map(ProductConverter::Convert).toList();
        return GetAllProductsResponse.builder().products(productList).build();
    }
}

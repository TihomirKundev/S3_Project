package com.example.Individual.controller;

import com.example.Individual.business.CreateProductUseCase;
import com.example.Individual.business.DeleteProductUseCase;
import com.example.Individual.business.GetProductsUseCase;
import com.example.Individual.business.UpdateProductUseCase;
import com.example.Individual.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping({"/product_staff"})
@AllArgsConstructor
@CrossOrigin
public class StaffProductController {
    private final GetProductsUseCase getProductsUseCase;
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    @GetMapping
    public ResponseEntity<GetAllProductsResponse> getProducts() {
        return ResponseEntity.ok(this.getProductsUseCase.getProducts());
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody @Valid CreateProductRequest request) {
        CreateProductResponse response = this.createProductUseCase.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("{SKU}")
    public ResponseEntity<Void> updateProduct(@PathVariable("SKU") String SKU, @RequestBody @Valid UpdateProductRequest request){
        request.setSKU(SKU);
        updateProductUseCase.updateProduct(request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping({"{SKU}"})
    public ResponseEntity<Void> deleteProduct(@PathVariable String SKU) {
        this.deleteProductUseCase.deleteProduct(SKU);
        return ResponseEntity.noContent().build();
    }
}

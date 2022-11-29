package com.example.Individual.controller;

import com.example.Individual.dto.requests.CreateProductRequest;
import com.example.Individual.dto.requests.UpdateProductRequest;
import com.example.Individual.dto.responses.CreateProductResponse;
import com.example.Individual.dto.responses.GetAllProductsResponse;
import com.example.Individual.service.productUseCases.CreateProductUseCase;
import com.example.Individual.service.productUseCases.DeleteProductUseCase;
import com.example.Individual.service.productUseCases.GetProductsUseCase;
import com.example.Individual.service.productUseCases.UpdateProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping({"/product_staff/"})
@AllArgsConstructor
@CrossOrigin
public class ProductController {
    private final GetProductsUseCase getProductsUseCase;
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;


    @GetMapping
    public ResponseEntity<GetAllProductsResponse> getProducts() {
        return ResponseEntity.ok(this.getProductsUseCase.getProducts());
    }

    @RolesAllowed({"ROLE_STAFF"})
    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody @Valid CreateProductRequest request) {
        CreateProductResponse response = this.createProductUseCase.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @RolesAllowed({"ROLE_STAFF"})
    @PutMapping("{SKU}")
    public ResponseEntity<String> updateProduct(@RequestBody @Valid UpdateProductRequest request){
        String result = updateProductUseCase.updateProduct(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

    @RolesAllowed({"ROLE_STAFF"})
    @DeleteMapping({"{SKU}"})
    public ResponseEntity<Void> deleteProduct(@PathVariable String SKU) {
        this.deleteProductUseCase.deleteProduct(SKU);
        return ResponseEntity.accepted().build();
    }
}

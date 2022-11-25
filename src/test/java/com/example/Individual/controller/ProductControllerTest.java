package com.example.Individual.controller;

import com.example.Individual.dto.entities.Product;
import com.example.Individual.dto.requests.CreateProductRequest;
import com.example.Individual.dto.requests.UpdateProductRequest;
import com.example.Individual.dto.responses.CreateProductResponse;
import com.example.Individual.dto.responses.GetAllProductsResponse;
import com.example.Individual.service.productUseCases.CreateProductUseCase;
import com.example.Individual.service.productUseCases.DeleteProductUseCase;
import com.example.Individual.service.productUseCases.GetProductsUseCase;
import com.example.Individual.service.productUseCases.UpdateProductUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetProductsUseCase getProductsUseCase;
    @MockBean
    private CreateProductUseCase createProductUseCase;
    @MockBean
    private UpdateProductUseCase updateProductUseCase;
    @MockBean
    private DeleteProductUseCase deleteProductUseCase;

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"STAFF"})
    void getProducts() throws Exception {
        Product product = Product.builder()
                .SKU("Kit_123")
                .category("Kitchen")
                .name("Table")
                .description("Test")
                .maker("None")
                .countryOfOrigin("Netherlands")
                .price(299.99)
                .weight(23.91)
                .build();
        List<Product> products = new ArrayList<>();
        products.add(product);
        GetAllProductsResponse getAllProductsResponse = GetAllProductsResponse.builder()
                .products(products)
                .build();
        when(getProductsUseCase.getProducts()).thenReturn(getAllProductsResponse);

        mockMvc.perform(get("/product_staff/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                        {"products":[{"category":"Kitchen","name":"Table","description":"Test","maker":"None","countryOfOrigin":"Netherlands","price":299.99,"weight":23.91,"sku":"Kit_123"}]}
                        """));
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"STAFF"})
    void createProduct() throws Exception {
        CreateProductRequest createProductRequest = CreateProductRequest.builder()
                .SKU("Kit_123")
                .category("Kitchen")
                .name("Table")
                .description("Test")
                .maker("None")
                .countryOfOrigin("Netherlands")
                .price(299.99)
                .weight(23.91)
                .build();
        CreateProductResponse createProductResponse = CreateProductResponse.builder()
                .result("Successfully created product!")
                .build();
        when(createProductUseCase.createProduct(createProductRequest)).thenReturn(createProductResponse);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(createProductRequest);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/product_staff/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON))
                .andExpect(status().isCreated())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                        {"result": "Successfully created product!"}
                        """));
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"STAFF"})
    void updateProduct() throws Exception {
        UpdateProductRequest request = UpdateProductRequest.builder()
                .SKU("Kit_123")
                .description("Test")
                .price(299.99)
                .build();
        when(updateProductUseCase.updateProduct(request)).thenReturn("Success");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(request);
        mockMvc.perform( MockMvcRequestBuilders
                        .put("/product_staff/{SKU}", "Kit_123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON))
                .andExpect(status().isAccepted())
                .andExpect(content().string("Success"));
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"STAFF"})
    void deleteProduct() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders.delete("/product_staff/{SKU}", "Kit_123") )
                .andExpect(status().isAccepted());
    }
}
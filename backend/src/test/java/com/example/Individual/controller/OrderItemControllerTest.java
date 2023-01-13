package com.example.Individual.controller;

import  com.example.Individual.dto.entities.OrderItem;
import com.example.Individual.dto.entities.Product;
import com.example.Individual.dto.requests.AddProductRequest;
import com.example.Individual.dto.requests.ChangeQuantityAndRemoveOrderItemRequest;
import com.example.Individual.dto.responses.GetItemsForActiveOrderResponse;
import com.example.Individual.persistence.product.ProductEntity;
import com.example.Individual.service.orderItemUseCases.*;
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

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class OrderItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddProductUseCase addProductUseCase;
    @MockBean
    private DecreaseOrderItemQuantityUseCase decreaseOrderItemQuantityUseCase;
    @MockBean
    private DeleteAllItemsForOrderUseCase deleteAllItemsForOrderUseCase;
    @MockBean
    private GetItemsForActiveOrderUseCase getItemsForActiveOrderUseCase;
    @MockBean
    private IncreaseOrderItemQuantityUseCase increaseOrderItemQuantityUseCase;
    @MockBean
    private RemoveOrderItemUseCase removeOrderItemUseCase;

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"CLIENT"})
    void addProduct() throws Exception{
        ProductEntity product = ProductEntity.builder()
                .sku("KIT_123")
                .category("Kitchen")
                .name("Sink")
                .description("Test")
                .maker("Ikea")
                .countryOfOrigin("Belgium")
                .price(299.99)
                .weight(21.34)
                .build();
        AddProductRequest request = AddProductRequest.builder()
                .orderNum(1)
                .product(product)
                .quantity(2)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/orderItems/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"CLIENT"})
    void decreaseQuantity() throws Exception{
        ProductEntity product = ProductEntity.builder()
                .sku("KIT_123")
                .category("Kitchen")
                .name("Sink")
                .description("Test")
                .maker("Ikea")
                .countryOfOrigin("Belgium")
                .price(299.99)
                .weight(21.34)
                .build();
        ChangeQuantityAndRemoveOrderItemRequest request = ChangeQuantityAndRemoveOrderItemRequest.builder()
                .orderNum(1)
                .product(product)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/orderItems/decrease_quantity")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"CLIENT"})
    void increaseQuantity() throws Exception{
        ProductEntity product = ProductEntity.builder()
                .sku("KIT_123")
                .category("Kitchen")
                .name("Sink")
                .description("Test")
                .maker("Ikea")
                .countryOfOrigin("Belgium")
                .price(299.99)
                .weight(21.34)
                .build();
        ChangeQuantityAndRemoveOrderItemRequest request = ChangeQuantityAndRemoveOrderItemRequest.builder()
                .orderNum(1)
                .product(product)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/orderItems/increase_quantity")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"CLIENT"})
    void removeItem() throws Exception{
        ProductEntity product = ProductEntity.builder()
                .sku("KIT_123")
                .category("Kitchen")
                .name("Sink")
                .description("Test")
                .maker("Ikea")
                .countryOfOrigin("Belgium")
                .price(299.99)
                .weight(21.34)
                .build();
        ChangeQuantityAndRemoveOrderItemRequest request = ChangeQuantityAndRemoveOrderItemRequest.builder()
                .orderNum(1)
                .product(product)
                .build();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/orderItems/order_item")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"CLIENT"})
    void removeAllItems() throws Exception{
        mockMvc.perform(delete("/orderItems/all_items/{orderNum}", 1))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"CLIENT"})
    void getItems() throws Exception{
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
        OrderItem orderItem = OrderItem.builder()
                .orderNum(1)
                .product(product)
                .quantity(1)
                .build();
        GetItemsForActiveOrderResponse response = GetItemsForActiveOrderResponse.builder()
                .orderItems(List.of(orderItem))
                .build();
        when(getItemsForActiveOrderUseCase.getItems(1)).thenReturn(response);
        mockMvc.perform(get("/orderItems/{orderNum}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                        {"orderItems":[{"orderNum":1,"product":{"category":"Kitchen","name":"Table","description":"Test","maker":"None","countryOfOrigin":"Netherlands","price":299.99,"weight":23.91,"sku":"Kit_123"},"quantity":1}]}
                        """));
    }
}
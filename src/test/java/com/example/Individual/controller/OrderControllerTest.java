package com.example.Individual.controller;

import com.example.Individual.dto.entities.Order;
import com.example.Individual.dto.responses.GetPastOrdersForClientResponse;
import com.example.Individual.service.orderUseCases.CreateNewOrderUseCase;
import com.example.Individual.service.orderUseCases.GetActiveOrderUseCase;
import com.example.Individual.service.orderUseCases.GetPastOrdersForClientUseCase;
import com.example.Individual.service.orderUseCases.PayOrderUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetActiveOrderUseCase getActiveOrderUseCase;
    @MockBean
    private CreateNewOrderUseCase createNewOrderUseCase;
    @MockBean
    private GetPastOrdersForClientUseCase getPastOrdersForClientUseCase;
    @MockBean
    private PayOrderUseCase payOrderUseCase;

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"CLIENT"})
    void getActiveOrder() throws Exception{
        Order order = Order.builder()
                .clientEmail("tihomirkandev@gmail.com")
                .orderNum(1234)
                .products(new ArrayList<>(){})
                .isItActive(true)
                .totalPrice(299.99)
                .build();
        when(getActiveOrderUseCase.getActiveOrder(any(String.class))).thenReturn(order);
        mockMvc.perform(get("/orders/active_order"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                        {"clientEmail":"tihomirkandev@gmail.com","orderNum":1234,"products":[],"totalPrice":299.99,"itActive":true}
                        """));
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"CLIENT"})
    void createNewOrder() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/orders/"))
                .andExpect(status().isOk());
        verify(createNewOrderUseCase).createOrder("tihomir");
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"CLIENT"})
    void getPastOrders() throws Exception{
        Order order = Order.builder()
                .clientEmail("tihomirkandev@gmail.com")
                .orderNum(1234)
                .products(new ArrayList<>(){})
                .isItActive(false)
                .totalPrice(299.99)
                .build();
        GetPastOrdersForClientResponse getPastOrdersForClientResponse = GetPastOrdersForClientResponse.builder()
                .orders(List.of(order))
                .build();
        when(getPastOrdersForClientUseCase.getPastOrders(any(String.class))).thenReturn(getPastOrdersForClientResponse);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/orders/past_orders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                        {"orders":[{"clientEmail":"tihomirkandev@gmail.com","orderNum":1234,"products":[],"totalPrice":299.99,"itActive":false}]}
                        """));
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"CLIENT"})
    void payOrder() throws Exception{
        mockMvc.perform( MockMvcRequestBuilders.put("/orders/") )
                .andExpect(status().isOk());
        verify(payOrderUseCase).payOrder("tihomir");
    }
}
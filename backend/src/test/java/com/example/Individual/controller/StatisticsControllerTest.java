package com.example.Individual.controller;

import com.example.Individual.service.statisticsUseCases.CountProductsUseCase;
import com.example.Individual.service.statisticsUseCases.CountStaffUseCase;
import com.example.Individual.service.statisticsUseCases.CountTotalOrdersUseCase;
import com.example.Individual.service.statisticsUseCases.TotalRegisteredUsersUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class StatisticsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountProductsUseCase countProductsUseCase;
    @MockBean
    private CountStaffUseCase countStaffUseCase;
    @MockBean
    private CountTotalOrdersUseCase countTotalOrdersUseCase;
    @MockBean
    private TotalRegisteredUsersUseCase totalRegisteredUsersUseCase;

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir", roles = {"MANAGER"})
    void countProducts() throws Exception{
        when(countProductsUseCase.countProducts()).thenReturn(1L);
        mockMvc.perform(get("/statistics/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().string("1"));
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir", roles = {"MANAGER"})
    void countStaff() throws Exception{
        when(countStaffUseCase.countStaff()).thenReturn(1L);
        mockMvc.perform(get("/statistics/staff"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().string("1"));
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir", roles = {"MANAGER"})
    void countOrders() throws Exception{
        when(countTotalOrdersUseCase.countOrders()).thenReturn(1L);
        mockMvc.perform(get("/statistics/orders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().string("1"));
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir", roles = {"MANAGER"})
    void countRegisteredUsers() throws Exception{
        when(totalRegisteredUsersUseCase.totalCustomers()).thenReturn(1L);
        mockMvc.perform(get("/statistics/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().string("1"));
    }
}
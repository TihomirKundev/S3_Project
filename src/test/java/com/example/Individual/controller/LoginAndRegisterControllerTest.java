package com.example.Individual.controller;

import com.example.Individual.dto.requests.LoginRequest;
import com.example.Individual.dto.responses.LoginResponse;
import com.example.Individual.service.loginUseCases.LoginUseCase;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class LoginAndRegisterControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private LoginUseCase loginUseCase;

    @Test
    void login() throws Exception{
        LoginRequest request = LoginRequest.builder()
                .email("tihomirkandev@gmail.com")
                .password("1234")
                .build();
        LoginResponse response = LoginResponse.builder()
                .accessToken("Test")
                .build();
        when(loginUseCase.login(request)).thenReturn(response);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/loginAndRegister/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                        {"accessToken":"Test"}
                        """));
    }
}
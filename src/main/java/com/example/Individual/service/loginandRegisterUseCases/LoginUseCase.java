package com.example.Individual.service.loginandRegisterUseCases;

import com.example.Individual.dto.requests.LoginRequest;
import com.example.Individual.dto.responses.LoginResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest request);
}

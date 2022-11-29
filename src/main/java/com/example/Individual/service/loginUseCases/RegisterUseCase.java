package com.example.Individual.service.loginUseCases;

import com.example.Individual.dto.requests.RegisterRequest;
import com.example.Individual.dto.responses.LoginResponse;

public interface RegisterUseCase {
    LoginResponse register(RegisterRequest request);
}

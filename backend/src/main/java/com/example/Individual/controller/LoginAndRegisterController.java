package com.example.Individual.controller;

import com.example.Individual.dto.requests.LoginRequest;
import com.example.Individual.dto.requests.RegisterRequest;
import com.example.Individual.dto.responses.LoginResponse;
import com.example.Individual.service.loginandRegisterUseCases.LoginUseCase;
import com.example.Individual.service.loginandRegisterUseCases.RegisterUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/loginAndRegister/")
@RequiredArgsConstructor
@CrossOrigin
public class LoginAndRegisterController {
    private final LoginUseCase loginUseCase;
    private final RegisterUseCase registerUseCase;
    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest){
        LoginResponse loginResponse = loginUseCase.login(loginRequest);
        return  ResponseEntity.ok(loginResponse);
    }
    @PostMapping("register")
    public ResponseEntity<LoginResponse> register(@RequestBody @Valid RegisterRequest registerRequest){
        LoginResponse loginResponse = registerUseCase.register(registerRequest);
        return ResponseEntity.ok(loginResponse);
    }
}

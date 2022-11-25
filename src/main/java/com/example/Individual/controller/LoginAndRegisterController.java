package com.example.Individual.controller;

import com.example.Individual.dto.requests.LoginRequest;
import com.example.Individual.dto.responses.LoginResponse;
import com.example.Individual.service.loginUseCases.LoginUseCase;
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
    @GetMapping
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest){
        LoginResponse loginResponse = loginUseCase.login(loginRequest);
        return  ResponseEntity.ok(loginResponse);
    }
}

package com.example.Individual.service.loginUseCases.impl;

import com.example.Individual.configuration.security.AccessToken;
import com.example.Individual.configuration.security.AccessTokenEncoder;
import com.example.Individual.configuration.security.Roles;
import com.example.Individual.dto.requests.RegisterRequest;
import com.example.Individual.dto.responses.LoginResponse;
import com.example.Individual.persistence.client.ClientEntity;
import com.example.Individual.persistence.client.ClientRepository;
import com.example.Individual.service.loginUseCases.RegisterUseCase;
import com.example.Individual.service.validators.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class RegisterUseCaseImpl implements RegisterUseCase {
    private final ClientRepository clientRepository;
    private final EmailValidator emailValidator;
    private final PasswordEncoder passwordEncoder;
    private final AccessTokenEncoder accessTokenEncoder;
    @Override
    public LoginResponse register(RegisterRequest request) {
        try{
            this.emailValidator.validateEmailForCreateForClient(request.getEmail());
        }catch (Exception e){
            return LoginResponse.builder().accessToken("Email is invalid").build();
        }
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        ClientEntity client = ClientEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(encodedPassword)
                .orders(new ArrayList<>())
                .build();
        clientRepository.saveAndFlush(client);
        String accessToken = accessTokenEncoder.encode(
                AccessToken.builder()
                        .email(request.getEmail())
                        .role(Roles.CLIENT)
                        .build()
        );
        return LoginResponse.builder().accessToken(accessToken).build();
    }
}

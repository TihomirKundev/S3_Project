package com.example.Individual.service.loginandRegisterUseCases;

import com.example.Individual.configuration.security.AccessToken;
import com.example.Individual.configuration.security.AccessTokenEncoder;
import com.example.Individual.configuration.security.Roles;
import com.example.Individual.dto.requests.RegisterRequest;
import com.example.Individual.persistence.client.ClientEntity;
import com.example.Individual.persistence.client.ClientRepository;
import com.example.Individual.service.loginandRegisterUseCases.impl.RegisterUseCaseImpl;
import com.example.Individual.service.validators.EmailValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterUseCaseTest {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private EmailValidator emailValidator;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private AccessTokenEncoder accessTokenEncoder;
    @InjectMocks
    private RegisterUseCaseImpl registerUseCase;

    @Test
    void register() {
        String firstName = "Tihomir";
        String lastName = "Kandev";
        String email = "tihomirkandev@gmail.com";
        String password = "1234";
        AccessToken accessToken = AccessToken.builder()
                .email(email)
                .role(Roles.CLIENT)
                .build();
        RegisterRequest request = RegisterRequest.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
        ClientEntity client = ClientEntity.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .orders(new ArrayList<>())
                .build();
        when(emailValidator.validateEmailForCreateForClient(request.getEmail())).thenReturn("Email is right!");
        when(accessTokenEncoder.encode(accessToken)).thenReturn("Success");
        String accessTokenResult = registerUseCase.register(request).getAccessToken();
        assertEquals("Success", accessTokenResult);
        verify(clientRepository).saveAndFlush(isA(ClientEntity.class));
        verify(emailValidator).validateEmailForCreateForClient(request.getEmail());
        verify(passwordEncoder).encode(request.getPassword());
        verify(accessTokenEncoder).encode(accessToken);
    }
}
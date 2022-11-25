package com.example.Individual.service.loginUseCases;

import com.example.Individual.configuration.security.AccessToken;
import com.example.Individual.configuration.security.AccessTokenEncoder;
import com.example.Individual.configuration.security.Roles;
import com.example.Individual.dto.requests.LoginRequest;
import com.example.Individual.persistence.client.ClientEntity;
import com.example.Individual.persistence.client.ClientRepository;
import com.example.Individual.persistence.manager.ManagerEntity;
import com.example.Individual.persistence.manager.ManagerRepository;
import com.example.Individual.persistence.staff.StaffEntity;
import com.example.Individual.persistence.staff.StaffRepository;
import com.example.Individual.service.loginUseCases.impl.LoginUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginUseCaseTest {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ManagerRepository managerRepository;
    @Mock
    private StaffRepository staffRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private AccessTokenEncoder accessTokenEncoder;
    @InjectMocks
    private LoginUseCaseImpl loginUseCase;

    @Test
    void login_asClient() {
        String email = "tihomirkandev@gmail.com";
        String password = "1234";
        AccessToken accessToken = AccessToken.builder()
                .email(email)
                .role(Roles.CLIENT)
                .build();
        LoginRequest request = LoginRequest.builder()
                .email(email)
                .password(password)
                .build();
        ClientEntity client = ClientEntity.builder()
                .firstName("Tihomir")
                .lastName("Kandev")
                .email(email)
                .password(password)
                .orders(new ArrayList<>())
                .build();
        when(clientRepository.findByEmail(email)).thenReturn(client);
        when(passwordEncoder.matches(password,password)).thenReturn(true);
        when(accessTokenEncoder.encode(accessToken)).thenReturn("Success");
        String accessTokenResult = loginUseCase.login(request).getAccessToken();
        assertEquals("Success",accessTokenResult);
    }
    @Test
    void login_asManager() {
        String email = "tihomirkandev@gmail.com";
        String password = "1234";
        AccessToken accessToken = AccessToken.builder()
                .email(email)
                .role(Roles.MANAGER)
                .build();
        LoginRequest request = LoginRequest.builder()
                .email(email)
                .password(password)
                .build();
        ManagerEntity manager = ManagerEntity.builder()
                .firstName("Tihomir")
                .lastName("Kandev")
                .contractStartDate(new Date())
                .contractEndDate(new Date())
                .email("tihomirkandev@gmail.com")
                .password("1234")
                .build();
        when(clientRepository.findByEmail(email)).thenReturn(null);
        when(managerRepository.findByEmail(email)).thenReturn(manager);
        when(passwordEncoder.matches(password,password)).thenReturn(true);
        when(accessTokenEncoder.encode(accessToken)).thenReturn("Success");
        String accessTokenResult = loginUseCase.login(request).getAccessToken();
        assertEquals("Success",accessTokenResult);
    }
    @Test
    void login_asStaff() {
        String email = "tihomirkandev@gmail.com";
        String password = "1234";
        AccessToken accessToken = AccessToken.builder()
                .email(email)
                .role(Roles.STAFF)
                .build();
        LoginRequest request = LoginRequest.builder()
                .email(email)
                .password(password)
                .build();
        StaffEntity staff = StaffEntity.builder()
                .firstName("Tihomir")
                .lastName("Kandev")
                .contractStartDate(new Date())
                .contractEndDate(new Date())
                .email("tihomirkandev@gmail.com")
                .password("1234")
                .build();
        when(clientRepository.findByEmail(email)).thenReturn(null);
        when(managerRepository.findByEmail(email)).thenReturn(null);
        when(staffRepository.findByEmail(email)).thenReturn(staff);
        when(passwordEncoder.matches(password,password)).thenReturn(true);
        when(accessTokenEncoder.encode(accessToken)).thenReturn("Success");
        String accessTokenResult = loginUseCase.login(request).getAccessToken();
        assertEquals("Success",accessTokenResult);
    }
}
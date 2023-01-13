package com.example.Individual.service.loginandRegisterUseCases.impl;

import com.example.Individual.configuration.security.AccessToken;
import com.example.Individual.configuration.security.AccessTokenEncoder;
import com.example.Individual.configuration.security.Roles;
import com.example.Individual.dto.requests.LoginRequest;
import com.example.Individual.dto.responses.LoginResponse;
import com.example.Individual.persistence.client.ClientEntity;
import com.example.Individual.persistence.client.ClientRepository;
import com.example.Individual.persistence.manager.ManagerEntity;
import com.example.Individual.persistence.manager.ManagerRepository;
import com.example.Individual.persistence.staff.StaffEntity;
import com.example.Individual.persistence.staff.StaffRepository;
import com.example.Individual.service.loginandRegisterUseCases.LoginUseCase;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    private final ClientRepository clientRepository;
    private final ManagerRepository managerRepository;
    private final StaffRepository staffRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccessTokenEncoder accessTokenEncoder;
    @Override
    public LoginResponse login(LoginRequest request) {
        ClientEntity client = clientRepository.findByEmail(request.getEmail());
        ManagerEntity manager = managerRepository.findByEmail(request.getEmail());
        StaffEntity staff = staffRepository.findByEmail(request.getEmail());
        String accessToken;
        if(client != null && matchesPassword(request.getPassword(), client.getPassword())){
            accessToken = generateAccessToken(client.getEmail(), Roles.CLIENT);
            return LoginResponse.builder().accessToken(accessToken).build();
        }else if(manager != null && matchesPassword(request.getPassword(), manager.getPassword())){
            accessToken = generateAccessToken(manager.getEmail(), Roles.MANAGER);
            return LoginResponse.builder().accessToken(accessToken).build();
        }else if(staff != null && matchesPassword(request.getPassword(), staff.getPassword())){
            accessToken = generateAccessToken(staff.getEmail(), Roles.STAFF);
            return LoginResponse.builder().accessToken(accessToken).build();
        }else{
            return  LoginResponse.builder().accessToken("Error").build();
        }
    }
    private boolean matchesPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
    private String generateAccessToken(String email, Roles role){
        return accessTokenEncoder.encode(
                AccessToken.builder()
                        .email(email)
                        .role(role)
                        .build()
        );
    }
}

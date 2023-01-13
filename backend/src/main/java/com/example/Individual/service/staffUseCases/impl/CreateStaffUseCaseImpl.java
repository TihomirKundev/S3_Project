package com.example.Individual.service.staffUseCases.impl;

import com.example.Individual.dto.requests.CreateStaffRequest;
import com.example.Individual.dto.responses.CreateStaffResponse;
import com.example.Individual.persistence.staff.StaffEntity;
import com.example.Individual.persistence.staff.StaffRepository;
import com.example.Individual.service.staffUseCases.CreateStaffUseCase;
import com.example.Individual.service.validators.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class CreateStaffUseCaseImpl implements CreateStaffUseCase {
    private final StaffRepository staffRepository;
    private final EmailValidator emailValidator;
    private final PasswordEncoder passwordEncoder;

    public CreateStaffResponse createStaff(CreateStaffRequest request) {
        try{
            this.emailValidator.validateEmailForCreateForStaff(request.getEmail());
        }catch (Exception e){
            return CreateStaffResponse.builder().result("Email is invalid").build();
        }
        this.saveNewStaff(request);
        return CreateStaffResponse.builder().result("Successfully hired!").build();
    }

    @Transactional
    private void saveNewStaff(CreateStaffRequest staffRequest) {
        String encodedPassword = passwordEncoder.encode(staffRequest.getPassword());
        StaffEntity staffEntity = StaffEntity.builder()
                .firstName(staffRequest.getFirstName())
                .lastName(staffRequest.getLastName())
                .contractStartDate(staffRequest.getContractStartDate())
                .contractEndDate(staffRequest.getContractEndDate())
                .email(staffRequest.getEmail())
                .password(encodedPassword)
                .build();
        this.staffRepository.saveAndFlush(staffEntity);
    }
}
package com.example.Individual.business.impl;

import com.example.Individual.business.CreateStaffUseCase;
import com.example.Individual.business.PcnValidator;
import com.example.Individual.domain.CreateStaffRequest;
import com.example.Individual.domain.CreateStaffResponse;
import com.example.Individual.domain.persistence.StaffRepository;
import com.example.Individual.domain.persistence.entity.StaffEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateStaffUseCaseImpl implements CreateStaffUseCase {
    private final StaffRepository staffRepository;
    private final PcnValidator pcnValidator;

    public CreateStaffResponse createStaff(CreateStaffRequest request) {
        this.pcnValidator.validatePcnForCreate(request.getPcn());
        this.saveNewStaff(request);
        return CreateStaffResponse.builder().result("Successfully hired!").build();
    }

    private void saveNewStaff(CreateStaffRequest staffRequest) {
        StaffEntity staffEntity = StaffEntity.builder().pcn(staffRequest.getPcn()).firstName(staffRequest.getFirstName()).lastName(staffRequest.getLastName()).contractStartDate(staffRequest.getContractStartDate()).contractEndDate(staffRequest.getContractEndDate()).email(staffRequest.getEmail()).password(staffRequest.getPassword()).build();
        this.staffRepository.Hire(staffEntity);
    }
}
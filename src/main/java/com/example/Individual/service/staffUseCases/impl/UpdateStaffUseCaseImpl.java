package com.example.Individual.service.staffUseCases.impl;

import com.example.Individual.dto.requests.UpdateStaffRequest;
import com.example.Individual.persistence.staff.StaffRepository;
import com.example.Individual.service.staffUseCases.UpdateStaffUseCase;
import com.example.Individual.service.validators.ContractEndDateValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UpdateStaffUseCaseImpl implements UpdateStaffUseCase {
    private final StaffRepository staffRepository;
    private final ContractEndDateValidator contractEndDateValidator;
    @Override
    @Transactional
    public void updateStaff(UpdateStaffRequest request) {
        this.contractEndDateValidator.validateDate(request.getContractEndDate());
        this.staffRepository.updateContractEndDateByEmail(request.getContractEndDate(),request.getEmail());
    }
}

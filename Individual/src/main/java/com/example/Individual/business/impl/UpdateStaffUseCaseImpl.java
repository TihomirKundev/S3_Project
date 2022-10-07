package com.example.Individual.business.impl;

import com.example.Individual.business.ContractEndDateValidator;
import com.example.Individual.business.PcnValidator;
import com.example.Individual.business.UpdateStaffUseCase;
import com.example.Individual.domain.UpdateStaffRequest;
import com.example.Individual.domain.persistence.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateStaffUseCaseImpl implements UpdateStaffUseCase {
    private final StaffRepository staffRepository;
    private final PcnValidator pcnValidator;
    private final ContractEndDateValidator contractEndDateValidator;
    @Override
    public void updateStaff(UpdateStaffRequest request) {
        this.pcnValidator.validatePcnForDelete(request.getPcn());
        this.contractEndDateValidator.validateDate(request.getContractEndDate());
        this.staffRepository.Update(request.getPcn(),request.getContractEndDate());
    }
}

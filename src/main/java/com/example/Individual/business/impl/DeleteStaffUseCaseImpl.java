package com.example.Individual.business.impl;

import com.example.Individual.business.DeleteStaffUseCase;
import com.example.Individual.business.PcnValidator;
import com.example.Individual.domain.persistence.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteStaffUseCaseImpl implements DeleteStaffUseCase {
    private final StaffRepository staffRepository;
    private final PcnValidator pcnValidator;

    public void deleteStaff(Long pcn) {
        this.pcnValidator.validatePcnForDelete(pcn);
        this.staffRepository.Fire(pcn);
    }
}

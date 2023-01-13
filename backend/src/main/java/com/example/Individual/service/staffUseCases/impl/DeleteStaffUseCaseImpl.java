package com.example.Individual.service.staffUseCases.impl;

import com.example.Individual.persistence.staff.StaffRepository;
import com.example.Individual.service.staffUseCases.DeleteStaffUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class DeleteStaffUseCaseImpl implements DeleteStaffUseCase {
    private final StaffRepository staffRepository;

    @Transactional
    public void deleteStaff(String email) {
        this.staffRepository.deleteByEmail(email);
    }
}

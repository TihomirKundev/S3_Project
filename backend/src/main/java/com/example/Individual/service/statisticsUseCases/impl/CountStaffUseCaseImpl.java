package com.example.Individual.service.statisticsUseCases.impl;

import com.example.Individual.service.statisticsUseCases.CountStaffUseCase;
import com.example.Individual.persistence.staff.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountStaffUseCaseImpl implements CountStaffUseCase {
    private final StaffRepository staffRepository;
    @Override
    public long countStaff() {
        return staffRepository.countByEmailNotNull();
    }
}

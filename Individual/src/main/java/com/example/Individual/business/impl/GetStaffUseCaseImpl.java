package com.example.Individual.business.impl;

import com.example.Individual.business.GetStaffUseCase;
import com.example.Individual.domain.GetAllStaffResponse;
import com.example.Individual.domain.Staff;
import com.example.Individual.domain.persistence.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetStaffUseCaseImpl implements GetStaffUseCase {
    private final StaffRepository staffRepository;

    public GetAllStaffResponse getStaff() {
        List<Staff> staffList = this.staffRepository.GetAll().stream().map(StaffConverter::Convert).toList();
        return GetAllStaffResponse.builder().staff(staffList).build();
    }
}
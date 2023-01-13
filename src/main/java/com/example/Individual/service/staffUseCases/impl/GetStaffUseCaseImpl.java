package com.example.Individual.service.staffUseCases.impl;

import com.example.Individual.service.converters.StaffConverter;
import com.example.Individual.service.staffUseCases.GetStaffUseCase;
import com.example.Individual.dto.responses.GetAllStaffResponse;
import com.example.Individual.dto.entities.Staff;
import com.example.Individual.persistence.staff.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class GetStaffUseCaseImpl implements GetStaffUseCase {
    private final StaffRepository staffRepository;

    @Transactional
    public GetAllStaffResponse getStaff() {
        List<Staff> staffList = this.staffRepository.findAll().stream().map(StaffConverter::Convert).toList();
        return GetAllStaffResponse.builder().staff(staffList).build();
    }
}
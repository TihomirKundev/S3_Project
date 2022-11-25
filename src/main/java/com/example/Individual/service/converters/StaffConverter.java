package com.example.Individual.service.converters;

import com.example.Individual.dto.entities.Staff;
import com.example.Individual.persistence.staff.StaffEntity;

public class StaffConverter {
    private StaffConverter(){
    }

    public static Staff Convert(StaffEntity staffEntity){
        return Staff.builder()
                .firstName(staffEntity.getFirstName())
                .lastName(staffEntity.getLastName())
                .contractStartDate(staffEntity.getContractStartDate())
                .contractEndDate(staffEntity.getContractEndDate())
                .email(staffEntity.getEmail())
                .password(staffEntity.getPassword())
                .build();
    }
}

package com.example.Individual.business.impl;

import com.example.Individual.domain.Staff;
import com.example.Individual.domain.persistence.entity.StaffEntity;

public class StaffConverter {
    private StaffConverter(){
    }

    public static Staff Convert(StaffEntity staffEntity){
        return Staff.builder()
                .pcn(staffEntity.getPcn())
                .firstName(staffEntity.getFirstName())
                .lastName(staffEntity.getLastName())
                .contractStartDate(staffEntity.getContractStartDate())
                .contractEndDate(staffEntity.getContractEndDate())
                .email(staffEntity.getEmail())
                .password(staffEntity.getPassword())
                .build();
    }
}

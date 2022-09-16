package com.example.Individual.business.impl;

import com.example.Individual.domain.Manager;
import com.example.Individual.domain.persistence.entity.ManagerEntity;

public class ManagerConverter {
    private ManagerConverter(){
    }

    public static Manager Convert(ManagerEntity managerEntity){
        return Manager.builder()
                .pcn(managerEntity.getPcn())
                .firstName(managerEntity.getFirstName())
                .lastName(managerEntity.getLastName())
                .contractStartDate(managerEntity.getContractStartDate())
                .contractEndDate(managerEntity.getContractEndDate())
                .email(managerEntity.getEmail())
                .password(managerEntity.getPassword())
                .build();
    }
}

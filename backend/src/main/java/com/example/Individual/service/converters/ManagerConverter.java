package com.example.Individual.service.converters;

import com.example.Individual.dto.entities.Manager;
import com.example.Individual.persistence.manager.ManagerEntity;

public class ManagerConverter {
    private ManagerConverter(){
    }

    public static Manager Convert(ManagerEntity managerEntity){
        return Manager.builder()
                .firstName(managerEntity.getFirstName())
                .lastName(managerEntity.getLastName())
                .contractStartDate(managerEntity.getContractStartDate())
                .contractEndDate(managerEntity.getContractEndDate())
                .email(managerEntity.getEmail())
                .password(managerEntity.getPassword())
                .build();
    }
}

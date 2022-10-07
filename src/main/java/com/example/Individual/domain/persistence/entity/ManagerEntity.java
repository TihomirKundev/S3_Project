package com.example.Individual.domain.persistence.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data
public class ManagerEntity {
    private String pcn;
    private String firstName;
    private String lastName;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private String email;
    private String password;
}

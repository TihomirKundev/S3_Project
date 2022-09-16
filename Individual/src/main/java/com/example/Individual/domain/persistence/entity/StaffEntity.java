package com.example.Individual.domain.persistence.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class StaffEntity {
    private Long pcn;
    private String firstName;
    private String lastName;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private String email;
    private String password;
}

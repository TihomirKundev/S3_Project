package com.example.Individual.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    private String pcn;
    private String firstName;
    private String lastName;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private String email;
    private String password;
}

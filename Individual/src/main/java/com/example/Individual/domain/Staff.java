package com.example.Individual.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    private Long pcn;
    private String firstName;
    private String lastName;
    private Date contractStartDate;
    private Date contractEndDate;
    private String email;
    private String password;
}

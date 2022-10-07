package com.example.Individual.domain.persistence.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Builder
@Data
public class StaffEntity {
    private Long pcn;
    private String firstName;
    private String lastName;
    private Date contractStartDate;
    private Date contractEndDate;
    private String email;
    private String password;
}

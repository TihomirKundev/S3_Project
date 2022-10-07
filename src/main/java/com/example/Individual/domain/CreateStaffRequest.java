package com.example.Individual.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStaffRequest {
    @NotBlank
    @Min(1)
    private Long pcn;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private Date contractStartDate;
    @NotBlank
    private Date contractEndDate;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}

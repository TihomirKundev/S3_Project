package com.example.Individual.persistence.staff;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@Getter
@Entity
@Table(name = "staff")
public class StaffEntity {
    @NotBlank
    @Column(name = "first_name")
    private String firstName;
    @NotBlank
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @Column(name = "contract_start_date")
    private Date contractStartDate;
    @NotNull
    @Column(name = "contract_end_date")
    private Date contractEndDate;
    @Id
    @Column(name = "email")
    private String email;
    @NotBlank
    @Column(name = "password")
    private String password;
}

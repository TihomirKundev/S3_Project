package com.example.Individual.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class GetAllStaffResponse {
    private List<Staff> staff;
}

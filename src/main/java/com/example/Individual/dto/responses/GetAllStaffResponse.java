package com.example.Individual.dto.responses;

import com.example.Individual.dto.entities.Staff;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class GetAllStaffResponse {
    private List<Staff> staff;
}

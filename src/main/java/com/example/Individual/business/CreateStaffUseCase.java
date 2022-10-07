package com.example.Individual.business;

import com.example.Individual.domain.CreateStaffRequest;
import com.example.Individual.domain.CreateStaffResponse;

public interface CreateStaffUseCase {
    CreateStaffResponse createStaff(CreateStaffRequest request);
}
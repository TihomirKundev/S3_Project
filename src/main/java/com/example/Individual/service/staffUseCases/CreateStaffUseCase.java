package com.example.Individual.service.staffUseCases;

import com.example.Individual.dto.requests.CreateStaffRequest;
import com.example.Individual.dto.responses.CreateStaffResponse;

public interface CreateStaffUseCase {
    CreateStaffResponse createStaff(CreateStaffRequest request);
}
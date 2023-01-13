package com.example.Individual.service.staffUseCases;

import com.example.Individual.dto.requests.UpdateStaffRequest;
import com.example.Individual.persistence.staff.StaffRepository;
import com.example.Individual.service.staffUseCases.impl.UpdateStaffUseCaseImpl;
import com.example.Individual.service.validators.ContractEndDateValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UpdateStaffUseCaseTest {
    @Mock
    private StaffRepository staffRepository;
    @Mock
    private ContractEndDateValidator contractEndDateValidator;
    @InjectMocks
    private UpdateStaffUseCaseImpl updateStaffUseCase;
    @Test
    void updateStaff() {
        UpdateStaffRequest request = UpdateStaffRequest.builder()
                .email("tihomirkandev@gmail.com")
                .contractEndDate(new Date(2022,11,11))
                .build();
        updateStaffUseCase.updateStaff(request);
        verify(contractEndDateValidator).validateDate(request.getContractEndDate());
        verify(staffRepository).updateContractEndDateByEmail(request.getContractEndDate(),request.getEmail());
    }
}
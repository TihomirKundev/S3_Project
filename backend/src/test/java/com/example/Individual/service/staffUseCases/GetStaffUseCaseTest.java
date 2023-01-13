package com.example.Individual.service.staffUseCases;

import com.example.Individual.dto.entities.Staff;
import com.example.Individual.dto.responses.GetAllStaffResponse;
import com.example.Individual.persistence.staff.StaffEntity;
import com.example.Individual.persistence.staff.StaffRepository;
import com.example.Individual.service.staffUseCases.impl.GetStaffUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetStaffUseCaseTest {
    @Mock
    private StaffRepository staffRepository;
    @InjectMocks
    private GetStaffUseCaseImpl getStaffUseCase;
    @Test
    void getStaff() {
        Staff staff = Staff.builder()
                .firstName("Test")
                .lastName("Test")
                .contractEndDate(null)
                .contractEndDate(null)
                .email("t@gmail.com")
                .password("1234")
                .build();
        StaffEntity staff2 = StaffEntity.builder()
                .firstName("Test")
                .lastName("Test")
                .contractEndDate(null)
                .contractEndDate(null)
                .email("t@gmail.com")
                .password("1234")
                .build();
        GetAllStaffResponse expectedResponse = GetAllStaffResponse.builder().staff(List.of(staff)).build();
        when(staffRepository.findAll()).thenReturn(List.of(staff2));
        GetAllStaffResponse actualResponse = getStaffUseCase.getStaff();
        assertEquals(expectedResponse,actualResponse);
        verify(staffRepository).findAll();
    }
}
package com.example.Individual.service.staffUseCases;

import com.example.Individual.persistence.staff.StaffRepository;
import com.example.Individual.service.staffUseCases.impl.DeleteStaffUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteStaffUseCaseTest {
    @Mock
    private StaffRepository staffRepository;
    @InjectMocks
    private DeleteStaffUseCaseImpl deleteStaffUseCase;
    @Test
    void deleteStaff() {
        String email = "tihomirkandev@gmail.com";
        deleteStaffUseCase.deleteStaff(email);
        verify(staffRepository).deleteByEmail(email);
    }
}
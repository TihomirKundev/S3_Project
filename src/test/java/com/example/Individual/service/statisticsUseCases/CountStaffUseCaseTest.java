package com.example.Individual.service.statisticsUseCases;

import com.example.Individual.persistence.staff.StaffRepository;
import com.example.Individual.service.statisticsUseCases.impl.CountStaffUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountStaffUseCaseTest {
    @Mock
    private StaffRepository staffRepository;
    @InjectMocks
    private CountStaffUseCaseImpl countStaffUseCase;
    @Test
    void countStaff() {
        when(staffRepository.countByEmailNotNull()).thenReturn(3L);
        Long result = countStaffUseCase.countStaff();
        assertEquals(3L,result);
    }
}
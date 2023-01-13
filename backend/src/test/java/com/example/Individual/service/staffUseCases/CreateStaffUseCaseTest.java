package com.example.Individual.service.staffUseCases;

import com.example.Individual.dto.requests.CreateStaffRequest;
import com.example.Individual.dto.responses.CreateStaffResponse;
import com.example.Individual.persistence.staff.StaffRepository;
import com.example.Individual.service.exceptions.InvalidEmailException;
import com.example.Individual.service.staffUseCases.impl.CreateStaffUseCaseImpl;
import com.example.Individual.service.validators.EmailValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateStaffUseCaseTest {
    @Mock
    private StaffRepository staffRepository;
    @Mock
    private EmailValidator emailValidator;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private CreateStaffUseCaseImpl createStaffUseCase;
    @Test
    void createStaff_shouldReturnSuccess(){
        CreateStaffRequest request = CreateStaffRequest.builder()
                .firstName("Tihomir")
                .lastName("Kandev")
                .contractStartDate(new Date(2022, 10,21))
                .contractEndDate(new Date(2022, 11,21))
                .email("tihomirkandev@gmail.com")
                .password("tihomir0")
                .build();
        CreateStaffResponse response = createStaffUseCase.createStaff(request);
        String expectedMessage = "Successfully hired!";
        String actualMessage = response.getResult();
        assertEquals(expectedMessage,actualMessage);
        verify(emailValidator).validateEmailForCreateForStaff(request.getEmail());
    }
    @Test
    void createStaff_shouldThrowInvalidEmailException(){
        CreateStaffRequest request = CreateStaffRequest.builder()
                .firstName("Tihomir")
                .lastName("Kandev")
                .contractStartDate(new Date(2022, 10,21))
                .contractEndDate(new Date(2022, 11,21))
                .email("tihomirkandev@gmail.com")
                .password("tihomir0")
                .build();
        when(emailValidator.validateEmailForCreateForStaff(request.getEmail())).thenThrow(InvalidEmailException.class);
        CreateStaffResponse response = createStaffUseCase.createStaff(request);
        assertEquals("Email is invalid",response.getResult());
    }
}

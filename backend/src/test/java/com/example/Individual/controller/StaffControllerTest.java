package com.example.Individual.controller;

import com.example.Individual.dto.entities.Staff;
import com.example.Individual.dto.requests.CreateStaffRequest;
import com.example.Individual.dto.requests.UpdateStaffRequest;
import com.example.Individual.dto.responses.CreateStaffResponse;
import com.example.Individual.dto.responses.GetAllStaffResponse;
import com.example.Individual.service.staffUseCases.CreateStaffUseCase;
import com.example.Individual.service.staffUseCases.DeleteStaffUseCase;
import com.example.Individual.service.staffUseCases.GetStaffUseCase;
import com.example.Individual.service.staffUseCases.UpdateStaffUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class StaffControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetStaffUseCase getStaffUseCase;
    @MockBean
    private CreateStaffUseCase createStaffUseCase;
    @MockBean
    private UpdateStaffUseCase updateStaffUseCase;
    @MockBean
    private DeleteStaffUseCase deleteStaffUseCase;

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir",roles = {"MANAGER"})
    void getStaff() throws Exception {
        Staff staff = Staff.builder()
                .firstName("Tihomir")
                .lastName("Kandev")
                .contractStartDate(new Date(2022,11,10))
                .contractEndDate(new Date(2022,11,21))
                .email("tihomirkandev@gmail.com")
                .password("1234")
                .build();
        List<Staff> staffList = new ArrayList<>();
        staffList.add(staff);
        GetAllStaffResponse getAllStaffResponse = GetAllStaffResponse.builder()
                .staff(staffList)
                .build();
        when(getStaffUseCase.getStaff()).thenReturn(getAllStaffResponse);

        mockMvc.perform(get("/staff/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                        {"staff":[{"firstName": "Tihomir", "lastName": "Kandev", "email": "tihomirkandev@gmail.com", "password": "1234"}]}
                        """));
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir", roles = {"MANAGER"})
    void createStaff() throws Exception{
        CreateStaffRequest createStaffRequest = CreateStaffRequest.builder()
                .firstName("Tihomir")
                .lastName("Kandev")
                .contractStartDate(new Date(2022,11,10))
                .contractEndDate(new Date(2022,11,21))
                .email("tihomirkandev@gmail.com")
                .password("1234")
                .build();
        CreateStaffResponse createStaffResponse = CreateStaffResponse.builder()
                .result("Successfully hired!")
                .build();
        when(createStaffUseCase.createStaff(createStaffRequest)).thenReturn(createStaffResponse);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(createStaffRequest);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/staff/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJSON))
                .andExpect(status().isCreated())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                        {"result": "Successfully hired!"}
                        """));
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir", roles = {"MANAGER"})
    void updateStaff() throws Exception{
        UpdateStaffRequest request = UpdateStaffRequest.builder()
                .email("tihomirkandev@gmail.com")
                .contractEndDate(new Date(2022,11,21))
                .build();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(request);
        mockMvc.perform( MockMvcRequestBuilders
                .put("/staff/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "tihomir", password = "tihomir", roles = {"MANAGER"})
    void deleteStaff() throws Exception{
        mockMvc.perform( MockMvcRequestBuilders.delete("/staff/{email}", "tihomirkandev@gmail.com") )
                .andExpect(status().isAccepted());
    }
}
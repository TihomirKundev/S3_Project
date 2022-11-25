package com.example.Individual.controller;

import com.example.Individual.dto.requests.CreateStaffRequest;
import com.example.Individual.dto.responses.CreateStaffResponse;
import com.example.Individual.dto.responses.GetAllStaffResponse;
import com.example.Individual.dto.requests.UpdateStaffRequest;
import com.example.Individual.service.staffUseCases.CreateStaffUseCase;
import com.example.Individual.service.staffUseCases.DeleteStaffUseCase;
import com.example.Individual.service.staffUseCases.GetStaffUseCase;
import com.example.Individual.service.staffUseCases.UpdateStaffUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping({"/staff/"})
@AllArgsConstructor
@CrossOrigin
public class  StaffController {
    private final GetStaffUseCase getStaffUseCase;
    private final CreateStaffUseCase createStaffUseCase;
    private final UpdateStaffUseCase updateStaffUseCase;
    private final DeleteStaffUseCase deleteStaffUseCase;

    @RolesAllowed({"ROLE_MANAGER"})
    @GetMapping
    public ResponseEntity<GetAllStaffResponse> getStaff() {
        return ResponseEntity.ok(this.getStaffUseCase.getStaff());
    }

    @RolesAllowed({"ROLE_MANAGER"})
    @PostMapping
    public ResponseEntity<CreateStaffResponse> createStaff(@RequestBody @Valid CreateStaffRequest request) {
        CreateStaffResponse response = this.createStaffUseCase.createStaff(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @RolesAllowed({"ROLE_MANAGER"})
    @PutMapping("{email}")
    public ResponseEntity<Void> updateStaff(@RequestBody @Valid UpdateStaffRequest request){
        updateStaffUseCase.updateStaff(request);
        return ResponseEntity.ok().build();
    }

    @RolesAllowed({"ROLE_MANAGER"})
    @DeleteMapping({"{email}"})
    public ResponseEntity<Void> deleteStaff(@PathVariable String email) {
        this.deleteStaffUseCase.deleteStaff(email);
        return ResponseEntity.accepted().build();
    }
}

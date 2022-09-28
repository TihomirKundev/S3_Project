package com.example.Individual.controller;

import com.example.Individual.business.CreateStaffUseCase;
import com.example.Individual.business.DeleteStaffUseCase;
import com.example.Individual.business.GetStaffUseCase;
import com.example.Individual.domain.CreateStaffRequest;
import com.example.Individual.domain.CreateStaffResponse;
import com.example.Individual.domain.GetAllStaffResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping({"/staff"})
@AllArgsConstructor
@CrossOrigin
public class StaffController {
    private final GetStaffUseCase getStaffUseCase;
    private final CreateStaffUseCase createStaffUseCase;
    private final DeleteStaffUseCase deleteStaffUseCase;

    @GetMapping
    public ResponseEntity<GetAllStaffResponse> getStaff() {
        return ResponseEntity.ok(this.getStaffUseCase.getStaff());
    }

    @PostMapping
    public ResponseEntity<CreateStaffResponse> createStaff(@RequestBody @Valid CreateStaffRequest request) {
        CreateStaffResponse response = this.createStaffUseCase.createStaff(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping({"{pcn}"})
    public ResponseEntity<Void> deleteStaff(@PathVariable Long pcn) {
        this.deleteStaffUseCase.deleteStaff(pcn);
        return ResponseEntity.noContent().build();
    }
}

package com.example.Individual.controller;

import com.example.Individual.service.statisticsUseCases.CountProductsUseCase;
import com.example.Individual.service.statisticsUseCases.CountStaffUseCase;
import com.example.Individual.service.statisticsUseCases.CountTotalOrdersUseCase;
import com.example.Individual.service.statisticsUseCases.TotalRegisteredUsersUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping({"/statistics/"})
@AllArgsConstructor
@CrossOrigin
public class StatisticsController {
    private final CountProductsUseCase countProductsUseCase;
    private final CountStaffUseCase countStaffUseCase;
    private final CountTotalOrdersUseCase countTotalOrdersUseCase;
    private final TotalRegisteredUsersUseCase totalRegisteredUsersUseCase;
    @RolesAllowed({"ROLE_MANAGER"})
    @GetMapping("products")
    public ResponseEntity<Long> countProducts(){
        return ResponseEntity.ok(countProductsUseCase.countProducts());
    }
    @RolesAllowed({"ROLE_MANAGER"})
    @GetMapping("staff")
    public ResponseEntity<Long> countStaff(){
        return ResponseEntity.ok(countStaffUseCase.countStaff());
    }
    @RolesAllowed({"ROLE_MANAGER"})
    @GetMapping("orders")
    public ResponseEntity<Long> countOrders(){
        return ResponseEntity.ok(countTotalOrdersUseCase.countOrders());
    }
    @RolesAllowed({"ROLE_MANAGER"})
    @GetMapping("users")
    public ResponseEntity<Long> countRegisteredUsers(){
        return ResponseEntity.ok(totalRegisteredUsersUseCase.totalCustomers());
    }
}

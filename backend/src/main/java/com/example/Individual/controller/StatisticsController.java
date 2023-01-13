package com.example.Individual.controller;

import com.example.Individual.service.orderItemUseCases.CountSoldProductsUseCase;
import com.example.Individual.service.statisticsUseCases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/statistics/")
@RequiredArgsConstructor
@CrossOrigin
public class StatisticsController {
    private final CountProductsUseCase countProductsUseCase;
    private final CountStaffUseCase countStaffUseCase;
    private final CountTotalOrdersUseCase countTotalOrdersUseCase;
    private final TotalRegisteredUsersUseCase totalRegisteredUsersUseCase;
    private final CountPaidOrdersUseCase countPaidOrdersUseCase;
    private final CountSoldProductsUseCase countSoldProductsUseCase;
    private final CountPriceOfSoldProductsFromSpainUseCase countPriceOfSoldProductsFromSpainUseCase;
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
    @RolesAllowed({"ROLE_MANAGER"})
    @GetMapping("paid_orders")
    public ResponseEntity<Long> countPaidOrders(){
        return ResponseEntity.ok(countPaidOrdersUseCase.countPaidOrders());
    }
    @RolesAllowed({"ROLE_MANAGER"})
    @GetMapping("sold_products")
    public ResponseEntity<Long> soldProducts(){
        return ResponseEntity.ok(countSoldProductsUseCase.countSoldProducts());
    }
    @RolesAllowed({"ROLE_MANAGER"})
    @GetMapping("price_of_spain")
    public ResponseEntity<Double> soldProductsForSpain(){
        return ResponseEntity.ok(countPriceOfSoldProductsFromSpainUseCase.countPrice());
    }
}

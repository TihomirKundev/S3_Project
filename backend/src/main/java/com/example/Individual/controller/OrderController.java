package com.example.Individual.controller;

import com.example.Individual.dto.entities.Order;
import com.example.Individual.dto.responses.GetPastOrdersForClientResponse;
import com.example.Individual.service.orderUseCases.CreateNewOrderUseCase;
import com.example.Individual.service.orderUseCases.GetActiveOrderUseCase;
import com.example.Individual.service.orderUseCases.GetPastOrdersForClientUseCase;
import com.example.Individual.service.orderUseCases.PayOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/orders/")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {
    private final GetActiveOrderUseCase getActiveOrderUseCase;
    private final CreateNewOrderUseCase createNewOrderUseCase;
    private final GetPastOrdersForClientUseCase getPastOrdersForClientUseCase;
    private final PayOrderUseCase payOrderUseCase;
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("active_order")
    public ResponseEntity<Order> getActiveOrder(Authentication authentication) {
        return ResponseEntity.ok(this.getActiveOrderUseCase.getActiveOrder(authentication.getName()));
    }
    @RolesAllowed({"ROLE_CLIENT"})
    @PostMapping
    public ResponseEntity<Void> createNewOrder(Authentication authentication){
        this.createNewOrderUseCase.createOrder(authentication.getName());
        return ResponseEntity.ok().build();
    }
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("past_orders")
    public ResponseEntity<GetPastOrdersForClientResponse> getPastOrders(Authentication authentication){
        return ResponseEntity.ok(this.getPastOrdersForClientUseCase.getPastOrders(authentication.getName()));
    }
    @RolesAllowed({"ROLE_CLIENT"})
    @PutMapping()
    public ResponseEntity<Void> payOrder(Authentication authentication){
        this.payOrderUseCase.payOrder(authentication.getName());
        return ResponseEntity.ok().build();
    }
}

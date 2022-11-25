package com.example.Individual.controller;

import com.example.Individual.service.orderUseCases.CreateNewOrderUseCase;
import com.example.Individual.service.orderUseCases.GetActiveOrderUseCase;
import com.example.Individual.service.orderUseCases.GetPastOrdersForClientUseCase;
import com.example.Individual.service.orderUseCases.PayOrderUseCase;
import com.example.Individual.dto.responses.GetPastOrdersForClientResponse;
import com.example.Individual.dto.entities.Order;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping({"/orders/"})
@AllArgsConstructor
@CrossOrigin
public class OrderController {
    private final GetActiveOrderUseCase getActiveOrderUseCase;
    private final CreateNewOrderUseCase createNewOrderUseCase;
    private final GetPastOrdersForClientUseCase getPastOrdersForClientUseCase;
    private final PayOrderUseCase payOrderUseCase;
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("{email}/active_order")
    public ResponseEntity<Order> getActiveOrder(@PathVariable String email) {
        if(this.getActiveOrderUseCase.getActiveOrder(email) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }else {
            return ResponseEntity.ok(this.getActiveOrderUseCase.getActiveOrder(email));
        }
    }
    @RolesAllowed({"ROLE_CLIENT"})
    @PostMapping("{email}")
    public ResponseEntity<Void> createNewOrder(@PathVariable String email){
        String result = this.createNewOrderUseCase.createOrder(email);
        if(result.equals("Success")){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("{email}/past_orders")
    public ResponseEntity<GetPastOrdersForClientResponse> getPastOrders(@PathVariable String email){
        return ResponseEntity.ok(this.getPastOrdersForClientUseCase.getPastOrders(email));
    }
    @RolesAllowed({"ROLE_CLIENT"})
    @PutMapping("{email}")
    public ResponseEntity<Void> payOrder(@PathVariable String email){
        String result = this.payOrderUseCase.payOrder(email);
        if(result.equals("Success")){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

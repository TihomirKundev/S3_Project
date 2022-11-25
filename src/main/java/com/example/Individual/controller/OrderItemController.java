package com.example.Individual.controller;

import com.example.Individual.dto.requests.AddProductRequest;
import com.example.Individual.dto.requests.ChangeQuantityAndRemoveOrderItemRequest;
import com.example.Individual.dto.responses.GetItemsForActiveOrderResponse;
import com.example.Individual.service.orderItemUseCases.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping({"/orderItems/"})
@AllArgsConstructor
@CrossOrigin
public class OrderItemController {
    private final AddProductUseCase addProductUseCase;
    private final DecreaseOrderItemQuantityUseCase decreaseOrderItemQuantityUseCase;
    private final DeleteAllItemsForOrderUseCase deleteAllItemsForOrderUseCase;
    private final GetItemsForActiveOrderUseCase getItemsForActiveOrderUseCase;
    private final IncreaseOrderItemQuantityUseCase increaseOrderItemQuantityUseCase;
    private final RemoveOrderItemUseCase removeOrderItemUseCase;
    @RolesAllowed({"ROLE_CLIENT"})
    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody @Valid AddProductRequest request){
        this.addProductUseCase.addProductToOrder(request);
        return ResponseEntity.ok().build();
    }
    @RolesAllowed({"ROLE_CLIENT"})
    @PutMapping("decrease_quantity")
    public ResponseEntity<Void> decreaseQuantity(@RequestBody @Valid ChangeQuantityAndRemoveOrderItemRequest request){
        this.decreaseOrderItemQuantityUseCase.decreaseQuantity(request);
        return ResponseEntity.ok().build();
    }
    @RolesAllowed({"ROLE_CLIENT"})
    @PutMapping("increase_quantity")
    public ResponseEntity<Void> increaseQuantity(@RequestBody @Valid ChangeQuantityAndRemoveOrderItemRequest request){
        this.increaseOrderItemQuantityUseCase.increaseQuantity(request);
        return ResponseEntity.ok().build();
    }
    @RolesAllowed({"ROLE_CLIENT"})
    @DeleteMapping("order_item")
    public ResponseEntity<Void> removeItem(@RequestBody @Valid ChangeQuantityAndRemoveOrderItemRequest request){
        this.removeOrderItemUseCase.removeOrderItem(request);
        return ResponseEntity.ok().build();
    }
    @RolesAllowed({"ROLE_CLIENT"})
    @DeleteMapping("all_items/{orderNum}")
    public ResponseEntity<Void> removeAllItems(@PathVariable int orderNum){
        this.deleteAllItemsForOrderUseCase.deleteItems(orderNum);
        return ResponseEntity.ok().build();
    }
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("{orderNum}")
    public ResponseEntity<GetItemsForActiveOrderResponse> getItems(@PathVariable int orderNum){
        return ResponseEntity.ok(this.getItemsForActiveOrderUseCase.getItems(orderNum));
    }
}

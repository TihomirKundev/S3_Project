package com.example.Individual.dto.responses;

import com.example.Individual.dto.entities.OrderItem;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
public class GetItemsForActiveOrderResponse {
    @NotBlank
    private List<OrderItem> orderItems;
}

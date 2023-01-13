package com.example.Individual.dto.responses;

import com.example.Individual.dto.entities.Order;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class GetPastOrdersForClientResponse {
    @NotNull
    private List<Order> orders;
}

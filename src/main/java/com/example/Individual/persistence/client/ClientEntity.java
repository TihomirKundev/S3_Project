package com.example.Individual.persistence.client;

import com.example.Individual.persistence.order.OrderEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "clients")
public class ClientEntity {
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    @Id
    @Column(name = "email")
    public String email;
    @NotNull
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "clientEmail")
    @NotNull
    private List<OrderEntity> orders;
}

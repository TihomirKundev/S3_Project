package com.example.Individual.domain.persistence;

import com.example.Individual.domain.persistence.entity.ClientEntity;

public interface ClientRepository {
    boolean existByEmail(String email);
    ClientEntity Login(ClientEntity client);
    void Register(ClientEntity client);
    int countRegisteredUsers();
}

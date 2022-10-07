package com.example.Individual.domain.persistence;

public interface ClientRepository {
    boolean existByEmail(String email);
    //ClientEntity Login(ClientEntity client);
    //void Register(ClientEntity client);
    int countRegisteredUsers();
}

package com.example.Individual.domain.persistence.dalImpl;

import com.example.Individual.domain.persistence.ClientRepository;
import com.example.Individual.domain.persistence.entity.ClientEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DALClientRepositoryImpl implements ClientRepository {
    private final List<ClientEntity> clients;

    public DALClientRepositoryImpl(){this.clients = new ArrayList<>();}

    @Override
    public boolean existByEmail(String email) {
        return this.clients
                .stream()
                .anyMatch(clientEntity -> clientEntity.getEmail().equals(email));
    }

    /*@Override
    public ClientEntity Login(ClientEntity client) {
        Predicate<ClientEntity> checkEmail = x -> x.getEmail().equals(client.getEmail());
        Predicate<ClientEntity> checkPass = x -> x.getPassword().equals(client.getPassword());

        ClientEntity client1 = clients.stream()
                .filter(checkEmail.and(checkPass))
                .findFirst()
                .orElse(null);
        return client1;
    }

    @Override
    public void Register(ClientEntity client) {
        this.clients.add(client);
    }
*/
    @Override
    public int countRegisteredUsers() {
        return this.clients.size();
    }
}

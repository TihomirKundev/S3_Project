package com.example.Individual.persistence.login;

import org.springframework.stereotype.Repository;

@Repository
public class LoginRepositoryImpl implements LoginRepository {
    /*@Override
    public ClientEntity login(ClientEntity client) {
        Predicate<ClientEntity> checkEmail = x -> x.getEmail().equals(client.getEmail());
        Predicate<ClientEntity> checkPass = x -> x.getPassword().equals(client.getPassword());

        ClientEntity client1 = clients.stream()
                .filter(checkEmail.and(checkPass))
                .findFirst()
                .orElse(null);
        return client1;
    }

    @Override
    public void register(ClientEntity client) {
        this.clients.add(client);
    }
*/
}

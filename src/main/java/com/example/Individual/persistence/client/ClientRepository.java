package com.example.Individual.persistence.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<ClientEntity,String> {
    @Query("select c from ClientEntity c where c.email = ?1")
    ClientEntity findByEmail(String email);
    @Query("select count(c) from ClientEntity c where c.email is not null")
    long countByEmailNotNull();

    @Query("select (count(c) > 0) from ClientEntity c where c.email = ?1")
    boolean existsByEmail(String email);

}

package com.example.Individual.persistence.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManagerRepository extends JpaRepository<ManagerEntity, String> {
    @Query("select m from ManagerEntity m where m.email = ?1")
    ManagerEntity findByEmail(String email);

}

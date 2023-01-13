package com.example.Individual.persistence.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface StaffRepository extends JpaRepository<StaffEntity,Long> {
    @Transactional
    @Modifying
    @Query("update StaffEntity s set s.contractEndDate = ?1 where s.email = ?2")
    void updateContractEndDateByEmail(Date contractEndDate, String email);

    @Transactional
    @Modifying
    @Query("delete from StaffEntity s where s.email = ?1")
    void deleteByEmail(String email);

    @Query("select s from StaffEntity s where s.email = ?1")
    StaffEntity findByEmail(String email);

    @Query("select (count(s) > 0) from StaffEntity s where s.email = ?1")
    boolean existsByEmail(String email);

    @Query("select count(s) from StaffEntity s where s.email is not null")
    long countByEmailNotNull();
}

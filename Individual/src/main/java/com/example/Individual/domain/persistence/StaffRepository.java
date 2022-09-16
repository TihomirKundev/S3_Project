package com.example.Individual.domain.persistence;

import com.example.Individual.domain.persistence.entity.StaffEntity;

import java.util.List;

public interface StaffRepository {
    void Hire(StaffEntity staff);
    void UpdatePass(StaffEntity staff);
    void UpdateContractEndDate(StaffEntity staff);
    void Fire(Long pcn);
    List<StaffEntity> GetAll();
    int Count();
}

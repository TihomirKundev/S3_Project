package com.example.Individual.domain.persistence;

import com.example.Individual.domain.persistence.entity.StaffEntity;

import java.util.Date;
import java.util.List;

public interface StaffRepository {
    void Hire(StaffEntity staff);

    void Update(Long pcn, Date contractEndDate);

    void Fire(Long pcn);

    List<StaffEntity> GetAll();

    int Count();

    boolean existByPcn(Long pcn);

    StaffEntity GetStaff(Long pcn);
}

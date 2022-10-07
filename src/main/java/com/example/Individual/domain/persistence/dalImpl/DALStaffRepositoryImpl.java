package com.example.Individual.domain.persistence.dalImpl;

import com.example.Individual.domain.persistence.StaffRepository;
import com.example.Individual.domain.persistence.entity.StaffEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class DALStaffRepositoryImpl implements StaffRepository {
    private final List<StaffEntity> staffs;

    public DALStaffRepositoryImpl() { this.staffs = new ArrayList();}

    public void Hire(StaffEntity staff) {
        this.staffs.add(staff);
    }

    public void Update(Long pcn, Date contractEndDate) {
        staffs.stream()
                .filter(x -> x.getPcn().equals(pcn))
                .findFirst()
                .ifPresent(x -> x.setContractEndDate(contractEndDate));
    }

    public void Fire(Long pcn) {
        Predicate<StaffEntity> checkPcn = (x) -> {
            return x.getPcn().equals(pcn);
        };
        StaffEntity res = (StaffEntity)this.staffs.stream().filter(checkPcn).findFirst().orElse(null);
        this.staffs.remove(res);
    }

    public List<StaffEntity> GetAll() {
        return this.staffs;
    }

    public int Count() {
        return this.staffs.size();
    }

    public boolean existByPcn(Long pcn) {
        return this.staffs.stream().anyMatch((x) -> {
            return x.getPcn().equals(pcn);
        });
    }

    public StaffEntity GetStaff(Long pcn) {
        return null;
    }
}

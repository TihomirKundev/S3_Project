package com.example.Individual.domain.persistence.dbDummyInitializer;

import com.example.Individual.domain.persistence.ProductRepository;
import com.example.Individual.domain.persistence.StaffRepository;
import com.example.Individual.domain.persistence.entity.ProductEntity;
import com.example.Individual.domain.persistence.entity.StaffEntity;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@AllArgsConstructor
public class DataInitialise {
    private StaffRepository staffRepository;
    private ProductRepository productRepository;

    @SneakyThrows
    @EventListener({ApplicationReadyEvent.class})
    public void addDummyDataToStaffRepo() {
        this.staffRepository.Hire(StaffEntity.builder().pcn(111111L).firstName("Tihomir").lastName("Kandev").contractStartDate((new SimpleDateFormat("dd/MM/yyyy")).parse("08/08/2022")).contractEndDate((new SimpleDateFormat("dd/MM/yyyy")).parse("08/08/2023")).email("tkandev@gmail.com").password("Tk27092002").build());
    }

    @EventListener({ApplicationReadyEvent.class})
    public void addDummyDataToProductRepo() {
        this.productRepository.Create(ProductEntity.builder().SKU("KIT-1234").category("Kitchen").name("Kv1435s").description("Test1").maker("Inventum").countryOfOrigin("Germany").price(599.99).weight(120.0).build());
    }
}
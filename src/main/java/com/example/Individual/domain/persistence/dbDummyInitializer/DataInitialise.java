package com.example.Individual.domain.persistence.dbDummyInitializer;

import com.example.Individual.domain.persistence.OrderItemRepository;
import com.example.Individual.domain.persistence.OrderRepository;
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
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;
    @SneakyThrows
    @EventListener({ApplicationReadyEvent.class})
    public void addDummyDataToStaffRepo() {
        this.staffRepository.Hire(StaffEntity.builder().pcn(111111L).firstName("Tihomir").lastName("Kandev").contractStartDate((new SimpleDateFormat("dd/MM/yyyy")).parse("08/08/2022")).contractEndDate((new SimpleDateFormat("dd/MM/yyyy")).parse("08/08/2023")).email("tkandev@gmail.com").password("Tk27092002").build());
    }

    @EventListener({ApplicationReadyEvent.class})
    public void addDummyDataToProductRepo() {
        this.productRepository.Create(ProductEntity.builder().SKU("KIT-1234").category("Kitchen").name("Kv1435s").description("Test1").maker("Inventum").countryOfOrigin("Germany").price(599.99).weight(120.0).build());
        this.productRepository.Create(ProductEntity.builder().SKU("BAT-1234").category("Bathroom").name("Godmorgon").description("Test2").maker("Odensvik").countryOfOrigin("Korea").price(388.95).weight(23.9).build());
        this.productRepository.Create(ProductEntity.builder().SKU("BED-1234").category("Bedroom").name("Espevar").description("Test3").maker("Vestmarka").countryOfOrigin("China").price(380.00).weight(220.0).build());
        this.productRepository.Create(ProductEntity.builder().SKU("GAR-1234").category("Garden").name("Godmorgon").description("Test4").maker("Odensvik").countryOfOrigin("Korea").price(388.95).weight(23.9).build());
        this.productRepository.Create(ProductEntity.builder().SKU("KIT-5678").category("Kitchen").name("Godmorgon").description("Test5").maker("Odensvik").countryOfOrigin("Korea").price(388.95).weight(23.9).build());
        this.productRepository.Create(ProductEntity.builder().SKU("BAT-5678").category("Bathroom").name("Ragrund").description("Test6").maker("Bjorkan").countryOfOrigin("Japan").price(209.93).weight(31.1).build());
        this.productRepository.Create(ProductEntity.builder().SKU("BED-5678").category("Bedroom").name("Omsint").description("Test7").maker("Rosenvial").countryOfOrigin("Dutch").price(12.92).weight(0.92).build());
        this.productRepository.Create(ProductEntity.builder().SKU("GAR-5678").category("Garden").name("Godmorgon").description("Test8").maker("Odensvik").countryOfOrigin("Korea").price(388.95).weight(23.9).build());
    }

    @EventListener({ApplicationReadyEvent.class})
    public void addDummyDateToOrderRepo(){
        this.orderRepository.CreateNewOrder("tihomirkandev@gmail.com");
    }

    @EventListener({ApplicationReadyEvent.class})
    public void addDummyDataToOrderItemRepo(){
        this.orderItemRepository.addProduct(ProductEntity.builder().SKU("KIT-1234").category("Kitchen").name("Kv1435s").description("Test1").maker("Inventum").countryOfOrigin("Germany").price(599.99).weight(120.0).build(),2);
    }
}
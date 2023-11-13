package tn.esprit.devops_project.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.dto.SupplierDto;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;
import tn.esprit.devops_project.services.Iservices.ISupplierService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupplierServiceImplTestJunit {
    @Autowired
    ISupplierService supplierService;

    SupplierDto newsupplierDto =new SupplierDto(1L,"code1","label1", SupplierCategory.CONVENTIONNE,null);


    @Test
    void retrieveAllSuppliers() {
    }

    @Test
    @Order(1)
    void addUpdateSupplier() {
        SupplierDto addSupplierDto = supplierService.addUpdateSupplier(newsupplierDto);
        SupplierDto newsupplierDto =new SupplierDto(1L,"code2","label2", SupplierCategory.CONVENTIONNE,null);
        supplierService.addUpdateSupplier(newsupplierDto);
        Supplier res=supplierService.retrieveSupplier(1L);
        Assertions.assertEquals(res.getCode(),"code2");
    }

    @Test
    void deleteSupplier() {
    }

    @Test
    void retrieveSupplier() {
    }
}
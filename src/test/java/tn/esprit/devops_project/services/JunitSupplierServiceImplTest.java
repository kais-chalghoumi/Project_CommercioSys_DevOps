package tn.esprit.devops_project.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.dto.SupplierDto;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;
import tn.esprit.devops_project.services.Iservices.ISupplierService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JunitSupplierServiceImplTest {

    @Autowired
    ISupplierService supplierService;

    SupplierDto newsupplierDto =new SupplierDto(1L,"code1","label1", SupplierCategory.CONVENTIONNE);


    @Test
    @Order(1)
    void addUpdateSupplier() {
        SupplierDto addSupplierDto = supplierService.addUpdateSupplier(newsupplierDto);
        SupplierDto newsupplierDto =new SupplierDto(1L,"code2","label2", SupplierCategory.CONVENTIONNE);
        supplierService.addUpdateSupplier(newsupplierDto);
        Supplier res=supplierService.retrieveSupplier(1L);
        Assertions.assertEquals(res.getCode(),"code2");
        System.out.println("Add : Ok");
    }


    @Test
    @Order(2)
    void retrieveAllSuppliers() {
        List<Supplier> supplierList = supplierService.retrieveAllSuppliers();

        // Assert that the returned list is not null
        assertNotNull(supplierList);

        // Assert that the returned list is not empty
        assertFalse(supplierList.isEmpty());

        // You can add more specific assertions based on your requirements

        System.out.println("RetrieveAllSuppliersTest : Ok");
    }



    @Test
    @Order(3)
    void retrieveSupplier() {
        // Assuming contratService.retrieveContrat method returns a Contrat
        Supplier supplier = supplierService.retrieveSupplier(1L); // Replace 1 with the actual ID you want to retrieve

        // Add assertions based on your requirements
        assertNotNull(supplier);
        // Additional assertions...

        System.out.println("RetrieveSupplierTest : Ok");
    }
}
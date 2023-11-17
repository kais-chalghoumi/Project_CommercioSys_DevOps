package tn.esprit.devops_project.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;
import tn.esprit.devops_project.services.Iservices.ISupplierService;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupplierServiceImplJunitTest {

    @Autowired
    ISupplierService supplierService;

    Supplier newsupplier =new Supplier(1L,"code1","label1",null,null,null);

    @Test
    @Order(1)
    void addUpdateSupplier() {
        Supplier addSupplier = supplierService.addUpdateSupplier(newsupplier);
        Supplier newsupplier =new Supplier(1L,"code2","label2",SupplierCategory.CONVENTIONNE,null,null);
        supplierService.addUpdateSupplier(newsupplier);
        Supplier res=supplierService.retrieveSupplier(1L);
        Assertions.assertEquals(res.getCode(),"code2");
        System.out.println("Add : Ok");
    }

    @Test
    @Order(2)
    void retrieveAllSuppliers() {
        List<Supplier> supplierList = supplierService.retrieveAllSuppliers();
        Assertions.assertNotNull(supplierList);
        Assertions.assertFalse(supplierList.isEmpty());
        System.out.println("RetrieveAllSuppliersTest : Ok");
    }

    @Test
    @Order(3)
    void retrieveSupplier() {
        Supplier supplier = supplierService.retrieveSupplier(1L);
        Assertions.assertNotNull(supplier);
        System.out.println("RetrieveSupplierTest : Ok");
    }

}
package tn.esprit.devops_project.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.dto.SupplierDto;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.Iservices.ISupplierService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static tn.esprit.devops_project.entities.SupplierCategory.ORDINAIRE;

@ExtendWith(MockitoExtension.class)
class SupplierServiceImplTestMock {
@Mock
    SupplierRepository supplierRepository;
@InjectMocks
SupplierServiceImpl supplierService;
List<Supplier> Suppliers=new ArrayList<Supplier>(){
    {
        add(new Supplier(1L,"code2","label2", SupplierCategory.CONVENTIONNE,null,null));
        add(new Supplier(2L,"code3","label3", SupplierCategory.CONVENTIONNE,null,null));
    }
};
    @Test
    void retrieveAllSuppliers() {
        Mockito.when(supplierRepository.findAll()).thenReturn(Suppliers);
        List<Supplier> res=supplierService.retrieveAllSuppliers();
        Assertions.assertEquals(2,res.size());
    }

    @Test

    void addUpdateSupplier() {

    }

    @Test
    void deleteSupplier() {
    }

    @Test
    void retrieveSupplier() {
    }
}
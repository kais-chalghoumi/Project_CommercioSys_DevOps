package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;
import tn.esprit.devops_project.repositories.SupplierRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class SupplierServiceImplMockitoTest {

    @MockBean
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
        Supplier newSupplier = new Supplier();
        newSupplier.setIdSupplier(3L);
        newSupplier.setSupplierCategory(SupplierCategory.ORDINAIRE);
        newSupplier.setCode("hhh");
        newSupplier.setLabel("lkm");
        Mockito.when(supplierRepository.save(newSupplier)).thenReturn(newSupplier);
        Supplier addedSupplier = supplierService.addUpdateSupplier(newSupplier);
        Assertions.assertEquals(newSupplier, addedSupplier);
        Mockito.verify(supplierRepository).save(any(Supplier.class));
        System.err.println("AddSupplierTest : Ok");
    }

    @Test
    void testUpdateSupplier() {
        Supplier existingSupplier = Supplier.builder()
                .idSupplier(1L)
                .build();
        Mockito.when(supplierRepository.save(existingSupplier)).thenReturn(existingSupplier);
        Supplier updatedSupplier = supplierService.addUpdateSupplier(existingSupplier);
        Assertions.assertEquals(existingSupplier, updatedSupplier);
        Mockito.verify(supplierRepository).save(any(Supplier.class));
        System.err.println("UpdateContratTest : Ok");
    }

    @Test
    void deleteSupplier() {
    }

    @Test
    void retrieveSupplier() {
        Supplier supplier1 = new Supplier();
        supplier1.setIdSupplier(1L);
        Mockito.when(supplierRepository.findById(1L)).thenReturn(Optional.of(supplier1));
        Supplier retrievedSupplier = supplierService.retrieveSupplier(1L);
        Mockito.verify(supplierRepository).findById(1L);
        Assertions.assertEquals(supplier1, retrievedSupplier);
    }

}
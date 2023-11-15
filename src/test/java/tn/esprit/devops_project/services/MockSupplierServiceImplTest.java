package tn.esprit.devops_project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.devops_project.dto.SupplierDto;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;
import tn.esprit.devops_project.repositories.SupplierRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MockSupplierServiceImplTest {
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
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
        when(supplierRepository.findAll()).thenReturn(Suppliers);
        List<Supplier> res=supplierService.retrieveAllSuppliers();
        assertEquals(2,res.size());
    }

    @Test

    void addUpdateSupplier() {
        SupplierDto newSupplier = new SupplierDto();
        newSupplier.setIdSupplier(3L);
        newSupplier.setSupplierCategory(SupplierCategory.ORDINAIRE); // You can use java.util.Date for date fields
        newSupplier.setCode("hhh");
        newSupplier.setLabel("lkm"); // Replace with a valid enum value



        // Mock the behavior of the contratRepository to save the newContrat and return it
        when(supplierRepository.save(SupplierDto.toEntity(newSupplier))).thenReturn(SupplierDto.toEntity(newSupplier));

        // Call the service method
        // SupplierDto addedSupplier = supplierService.addUpdateSupplier(newSupplier);
        SupplierDto addedSupplier = supplierService.addUpdateSupplier(newSupplier);

        // Verify that the service method returned the added contract
        assertEquals(newSupplier, addedSupplier);

        // Verify that the save method was called on the contratRepository
        verify(supplierRepository).save(any(Supplier.class));

        System.err.println("AddSupplierTest : Ok");

    }

    @Test
    void testUpdateSupplier() {
        // Create a sample ContratDTO to update
        SupplierDto existingSupplierDTO = SupplierDto.builder()
                .idSupplier(1L)
                // Set other properties as needed
                .build();

        // Mock the behavior of the contratRepository to save the updated ContratDTO and return it
        when(supplierRepository.save(SupplierDto.toEntity(existingSupplierDTO))).thenReturn(SupplierDto.toEntity(existingSupplierDTO));

        // Call the service method
        SupplierDto updatedSupplierDTO = supplierService.addUpdateSupplier(existingSupplierDTO);

        // Verify that the service method returned the updated contractDTO
        assertEquals(existingSupplierDTO, updatedSupplierDTO);

        // Verify that the save method was called on the contratRepository
        verify(supplierRepository).save(any(Supplier.class));

        System.err.println("UpdateContratTest : Ok");
    }



    @Test
    void deleteSupplier() {
    }

    @Test
    void retrieveSupplier() {
        Supplier supplier1 = new Supplier();
        supplier1.setIdSupplier(1L);
        when(supplierRepository.findById(1L)).thenReturn(Optional.of(supplier1));
        Supplier retrievedSupplier = supplierService.retrieveSupplier(1L);
        verify(supplierRepository).findById(1L);
        assertEquals(supplier1, retrievedSupplier);
    }
}


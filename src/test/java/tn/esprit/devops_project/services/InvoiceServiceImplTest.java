package tn.esprit.devops_project.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.repositories.InvoiceRepository;

import java.util.*;

import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;
public class InvoiceServiceImplTest{
    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    @Mock
    private InvoiceRepository invoiceRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testRetrieveAllContrats() {
        // Create a list of sample Contrats
        List<Invoice> sampleInvoices = new ArrayList<>();

        Invoice invoice1 = new Invoice();
        invoice1.setIdInvoice((long)1);
        invoice1.setAmountInvoice(1000);
        // Set other properties as needed
        sampleInvoices.add(invoice1);

        Invoice invoice2 = new Invoice();
        invoice2.setIdInvoice((long)2);
        invoice2.setAmountInvoice(2000);
        // Set other properties as needed
        sampleInvoices.add(invoice2);

        // Mock the behavior of the contratRepository to return the sampleContrats when retrieveAllContrats is called
        when(invoiceRepository.findAll()).thenReturn(sampleInvoices);

        // Call the service method
        List<Invoice> resultInvoices = invoiceService.retrieveAllInvoices();

        // Verify that the service method returned the expected data
        assertEquals(sampleInvoices, resultInvoices);

        System.out.println("testRetrieveAllInvoices : SUCCESS");
    }


    @Test
    public void testRetrieveContrat() {
        // Create a sample Contrat with a known ID
        long id = 1;
        Invoice sampleInvoice = new Invoice();
        sampleInvoice.setIdInvoice(id);
        // Set other properties as needed

        // Mock the behavior of the contratRepository to return the sampleContrat when findById is called
        when(invoiceRepository.findById(id)).thenReturn(Optional.of(sampleInvoice));

        // Call the service method
        Invoice resultInvoice = invoiceService.retrieveInvoice(id);

        // Verify that the service method returned the expected Contrat
        assertEquals(sampleInvoice, resultInvoice);

        // Verify that the findById method was called on the contratRepository
        verify(invoiceRepository, times(1)).findById(id);

        System.out.println("testRetrieveInvoice : SUCCESS");
    }
}
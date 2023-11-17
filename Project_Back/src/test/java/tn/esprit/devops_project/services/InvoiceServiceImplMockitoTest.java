package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.InvoiceRepository;
import tn.esprit.devops_project.repositories.OperatorRepository;
import java.util.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class InvoiceServiceImplMockitoTest {

    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private OperatorRepository operatorRepository;

    @Test
    public void testRetrieveAllInvoices() {
        List<Invoice> sampleInvoices = new ArrayList<>();
        Invoice invoice1 = new Invoice();
        invoice1.setIdInvoice((long)1);
        invoice1.setAmountInvoice(1000);
        sampleInvoices.add(invoice1);
        Invoice invoice2 = new Invoice();
        invoice2.setIdInvoice((long)2);
        invoice2.setAmountInvoice(500);
        sampleInvoices.add(invoice2);
        Mockito.when(invoiceRepository.findAll()).thenReturn(sampleInvoices);
        List<Invoice> result = invoiceService.retrieveAllInvoices();
        Assertions.assertEquals(sampleInvoices, result);
        System.out.println("testRetrieveAllInvoices : SUCCESS");
    }

    @Test
    public void testRetrieveInvoice() {
        long id = 1;
        Invoice sampleInvoice = new Invoice();
        sampleInvoice.setIdInvoice(id);
        Mockito.when(invoiceRepository.findById(id)).thenReturn(Optional.of(sampleInvoice));
        Invoice result = invoiceService.retrieveInvoice(id);
        Assertions.assertEquals(sampleInvoice, result);
        Mockito.verify(invoiceRepository, times(1)).findById(id);
        System.out.println("testRetrieveInvoice : SUCCESS");
    }

    @Test
    public void getInvoicesBySupplierTest(){
        List<Invoice> sampleInvoices = new ArrayList<>();
        Invoice invoice1 = new Invoice();
        invoice1.setIdInvoice((long)1);
        Supplier supplier1 = new Supplier();
        supplier1.setIdSupplier((long)1);
        invoice1.setSupplier(supplier1);
        // Set other properties as needed
        sampleInvoices.add(invoice1);
        Invoice invoice2 = new Invoice();
        invoice2.setIdInvoice((long)2);
        Supplier supplier2 = new Supplier();
        supplier2.setIdSupplier((long)2);
        invoice2.setSupplier(supplier2);
        sampleInvoices.add(invoice2);
        Mockito.when(invoiceRepository.findAll()).thenReturn(sampleInvoices);
        List<Invoice> InvoicesResult = invoiceService.getInvoicesBySupplier((long)1);
        Assertions.assertEquals(InvoicesResult.contains(invoice1),true);
        System.out.println("testGetInvoiceBySupplier : SUCCESS");
    }

    @Test
    public void cancelInvoiceTest(){
        long id = 1;
        Invoice sampleInvoice = new Invoice();
        sampleInvoice.setIdInvoice(id);
        Mockito.when(invoiceRepository.findById(id)).thenReturn(Optional.of(sampleInvoice));
        invoiceService.cancelInvoice(id);
        Assertions.assertEquals(sampleInvoice.getArchived(),true);
        System.out.println("testCancelInvoice : SUCCESS");
    }

    @Test
    public void assignOperatorToInvoice(){
        long id = 1;
        Invoice sampleInvoice = new Invoice();
        sampleInvoice.setIdInvoice(id);
        Operator sampleOperator = new Operator();
        sampleOperator.setIdOperateur(id);
        Mockito.when(invoiceRepository.findById(id)).thenReturn(Optional.of(sampleInvoice));
        Mockito.when(operatorRepository.findById(id)).thenReturn(Optional.of(sampleOperator));
        invoiceService.assignOperatorToInvoice(id,id);
        Assertions.assertEquals(sampleOperator.getInvoices().contains(sampleInvoice),true);
        System.out.println("testAssignOperatorToInvoice : SUCCESS");
    }

//    @Test
//    public void getTotalAmountInvoiceBetweenDatesTest(){
//        //Date Fin et Date Debut
//        LocalDate dateD = LocalDate.of(2023, 9, 30);
//        Date dateDebut = Date.from(dateD.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//        LocalDate dateF = LocalDate.of(2023, 10, 30);
//        Date dateFin = Date.from(dateF.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//        // List Invoices
//        List<Invoice> sampleInvoices = new ArrayList<>();
//        Invoice invoice1 = new Invoice();
//        invoice1.setIdInvoice((long)1);
//        invoice1.setAmountInvoice(1000);
//        LocalDate dateInvoice1 = LocalDate.of(2023, 10, 2);
//        invoice1.setDateCreationInvoice(Date.from(dateInvoice1.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//        // Set other properties as needed
//        sampleInvoices.add(invoice1);
//        Invoice invoice2 = new Invoice();
//        invoice2.setIdInvoice((long)2);
//        invoice2.setAmountInvoice(500);
//        LocalDate dateInvoice2 = LocalDate.of(2023, 10, 3);
//        invoice1.setDateCreationInvoice(Date.from(dateInvoice2.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//        // Set other properties as needed
//        sampleInvoices.add(invoice2);
//        when(invoiceRepository.findAll()).thenReturn(sampleInvoices);
//       float resultAmount = invoiceService.getTotalAmountInvoiceBetweenDates(dateDebut,dateFin);
//       assertEquals(resultAmount,1500);
//        System.out.println("testTotalAmountBetweenDates : SUCCESS");
//    }

}
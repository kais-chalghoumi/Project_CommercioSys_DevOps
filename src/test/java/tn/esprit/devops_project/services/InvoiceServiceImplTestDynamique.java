package tn.esprit.devops_project.services;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.InvoiceRepository;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InvoiceServiceImplTestDynamique {

    @Autowired
    private InvoiceServiceImpl invoiceService;
    @Autowired
    private OperatorServiceImpl operatorService;
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private OperatorRepository operatorRepository;

    @Test
    public void testRetrieveAllInvoices() {
        List<Invoice> listInvoices = invoiceService.retrieveAllInvoices();
        Assertions.assertEquals(2,listInvoices.size());
    }


    @Test
    public void testRetrieveInvoice() {
        Invoice invoice = invoiceService.retrieveInvoice((long)1);
        Assertions.assertEquals(500,invoice.getAmountInvoice());
    }


    @Test
    public void testGetTotalAmountInvoiceBetweenDates() {
        LocalDate dateD = LocalDate.of(2023, 9, 30);
        Date dateDebut = Date.from(dateD.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        LocalDate dateF = LocalDate.of(2023, 10, 30);
        Date dateFin = Date.from(dateF.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        float Amount = invoiceService.getTotalAmountInvoiceBetweenDates(dateDebut,dateFin);
        Assertions.assertEquals(1500,Amount);

    }
    @Test
    @Transactional
    public void testCancelInvoice(){
        Invoice invoice = invoiceService.retrieveInvoice((long)1);
        invoiceService.cancelInvoice(invoice.getIdInvoice());
        Assertions.assertEquals(true,invoice.getArchived());
        //Réinitialiser la base de données
        invoice.setArchived(false);
        invoiceRepository.save(invoice);

    }

    @Test
    public void testGetInvoicesBySupplier(){
        List<Invoice> listInvoices = invoiceService.getInvoicesBySupplier((long)1);
        Assertions.assertEquals(1,listInvoices.size());
    }

    @Test
    @Transactional
    @Commit
    public void testAssignOperatorToInvoice(){
        Operator operator = operatorService.retrieveOperator((long)1);
        Invoice invoice = invoiceService.retrieveInvoice((long)1);
        invoiceService.assignOperatorToInvoice(operator.getIdOperateur(), invoice.getIdInvoice());
        Assertions.assertEquals(true,operator.getInvoices().contains(invoice));

        //Réinitialiser la base de données
        operator.getInvoices().remove(invoice);
        operatorRepository.save(operator);
    }
}
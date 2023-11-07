package tn.esprit.devops_project.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.InvoiceDetailRepository;
import tn.esprit.devops_project.repositories.InvoiceRepository;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.Iservices.IInvoiceService;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class InvoiceServiceImpl implements IInvoiceService {

	final InvoiceRepository invoiceRepository;
	final OperatorRepository operatorRepository;
	final InvoiceDetailRepository invoiceDetailRepository;
	final SupplierRepository supplierRepository;

	@Override
	public List<Invoice> retrieveAllInvoices() {
		return invoiceRepository.findAll();
	}
	@Override
	public void cancelInvoice(Long invoiceId) {
		// method 01
		Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow(() -> new NullPointerException("Invoice not found"));
		invoice.setArchived(true);
		invoiceRepository.save(invoice);
		//method 02 (Avec JPQL)
		invoiceRepository.updateInvoice(invoiceId);
	}

	@Override
	public Invoice retrieveInvoice(Long invoiceId) {

		return invoiceRepository.findById(invoiceId).orElseThrow(() -> new NullPointerException("Invoice not found"));
	}

	@Override
	public List<Invoice> getInvoicesBySupplier(Long idSupplier) {
		List<Invoice> listInvoices = new ArrayList<>();
		for ( Invoice inv : invoiceRepository.findAll() ){
			if (inv.getSupplier().getIdSupplier() ==  idSupplier){
				listInvoices.add(inv);
			}
		}
		return  listInvoices;
	}

	@Override
	public void assignOperatorToInvoice(Long idOperator, Long idInvoice) {
		Invoice invoice = invoiceRepository.findById(idInvoice).orElseThrow(() -> new NullPointerException("Invoice not found"));
		Operator operator = operatorRepository.findById(idOperator).orElseThrow(() -> new NullPointerException("Operator not found"));
		Set<Invoice> Invoices = new HashSet<>();
		Invoices.add(invoice);
		operator.setInvoices(Invoices);
		operatorRepository.save(operator);
	}

	@Override
	public float getTotalAmountInvoiceBetweenDates(Date startDate, Date endDate) {
		return invoiceRepository.getTotalAmountInvoiceBetweenDates(startDate, endDate);
	}


}
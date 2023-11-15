package tn.esprit.devops_project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.dto.SupplierDto;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.services.Iservices.ISupplierService;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/")
@CrossOrigin("*")
public class SupplierController {

	ISupplierService supplierService;

	@GetMapping("/supplier")
	public List<Supplier> getSuppliers() {
		return supplierService.retrieveAllSuppliers();
	}

	@GetMapping("/supplier/{supplierId}")
	public Supplier retrieveSupplier(@PathVariable Long supplierId) {
		return supplierService.retrieveSupplier(supplierId);
	}

	@PostMapping("/supplier")
	public SupplierDto addUpdateSupplier(@RequestBody SupplierDto s) {
		return supplierService.addUpdateSupplier(s);
	}

	@DeleteMapping("/supplier/{supplierId}")
	public void removeFournisseur(@PathVariable Long supplierId) {
		supplierService.deleteSupplier(supplierId);
	}

	@PutMapping("/supplier")
	public SupplierDto modifyFournisseur(@RequestBody SupplierDto s) {
		return supplierService.addUpdateSupplier(s);
	}


}

package tn.esprit.devops_project.services.Iservices;

import tn.esprit.devops_project.dto.SupplierDto;
import tn.esprit.devops_project.entities.Supplier;

import java.util.List;

public interface ISupplierService {

	List<Supplier> retrieveAllSuppliers();

	SupplierDto addUpdateSupplier(SupplierDto s);

	void deleteSupplier(Long id);



	Supplier retrieveSupplier(Long id);


}

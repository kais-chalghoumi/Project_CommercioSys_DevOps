package tn.esprit.devops_project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.services.Iservices.IOperatorService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/operator")
@CrossOrigin(origins = "http://localhost:4200")
public class OperatorController {

	IOperatorService operatorService;

	@GetMapping("/getOperators")
	public List<Operator> getOperators() {
		return operatorService.retrieveAllOperators();
	}

	@GetMapping("/retrieveoperator/{operatorId}")
	public Operator retrieveoperator(@PathVariable Long operatorId) {
		return operatorService.retrieveOperator(operatorId);
	}

	@PostMapping("/addOperator")
	public Operator addOperator(@RequestBody Operator operator) {
		return operatorService.addOperator(operator);
	}

	@DeleteMapping("/removeOperator/{operatorId}")
	public void removeOperator(@PathVariable Long operatorId) {
		operatorService.deleteOperator(operatorId);
	}

	@PutMapping("/modifyOperateur")
	public Operator modifyOperateur(@RequestBody Operator operator) {
		return operatorService.updateOperator(operator);
	}

}

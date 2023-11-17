package tn.esprit.devops_project.services.Iservices;

public interface IOperatorService {

	Operator addOperator(Operator operator);

	void deleteOperator(Long id);

	Operator updateOperator(Operator operator);

	Operator retrieveOperator(Long id);
}

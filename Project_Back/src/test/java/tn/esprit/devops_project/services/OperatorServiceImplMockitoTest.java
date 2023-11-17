package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import java.util.*;

@ExtendWith(MockitoExtension.class)
class OperatorServiceImplMockitoTest {

    @Mock
    OperatorRepository operatorRepository;

    @InjectMocks
    OperatorServiceImpl operatorService;

    Operator operator = new Operator(1L,"fname1","lname1","password1",null);

    List<Operator> operatorList = new ArrayList<Operator>() {
        {
            add(new Operator(2L,"fname2","lname2","password2",null));
            add(new Operator(3L,"fname3","lname3","password3",null));
        }
    };

    @Test
    void retrieveAllOperators() {
        Mockito.when(operatorRepository.findAll()).thenReturn(operatorList);
        List<Operator> list = operatorService.retrieveAllOperators();
        Assertions.assertEquals(2,list.size());
    }

    @Test
    void retrieveOperator() {
        Mockito.when(operatorRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operator));
        Operator operator1 = operatorService.retrieveOperator(100L);
        Assertions.assertNotNull(operator1);
    }

    @Test
    void addOperator() {
        Mockito.when(operatorRepository.save(Mockito.any(Operator.class))).thenReturn(operator);
        Operator result = operatorService.addOperator(operator);
        Assertions.assertEquals(1L,result.getIdOperateur());
    }

    @Test
    void deleteOperator() {
        Long idToDelete = 1L;
        Mockito.doNothing().when(operatorRepository).deleteById(idToDelete);
        operatorService.deleteOperator(idToDelete);
        Mockito.verify(operatorRepository, Mockito.times(1)).deleteById(idToDelete);
    }

    @Test
    void updateOperator() {
        Mockito.when(operatorRepository.save(Mockito.any(Operator.class))).thenReturn(operator);
        Operator updatedOperator = operatorService.updateOperator(operator);
        Assertions.assertEquals(operator.getIdOperateur(), updatedOperator.getIdOperateur());
        Assertions.assertEquals(operator.getFname(), updatedOperator.getFname());
        Mockito.verify(operatorRepository, Mockito.times(1)).save(Mockito.any(Operator.class));
    }

}
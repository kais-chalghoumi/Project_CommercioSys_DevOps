package tn.esprit.devops_project.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.services.Iservices.IOperatorService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
@Transactional
@TestMethodOrder(OrderAnnotation.class)
class OperatorServiceImplJUnitTest {

    @Autowired
    IOperatorService operatorService;

    Operator operator1 = new Operator(null,"test1","JUnit5","DevOps1",null);
    Operator operator2 = new Operator(null,"test2","JUnit5","DevOps2",null);

    @Test
    @Order(0)
    void addOperator() {
        Operator res = operatorService.addOperator(operator1);
        log.info(res.toString());
    }

    @Test
    @Order(1)
    void retrieveOperator() {
        operatorService.addOperator(operator1);
        Operator res = operatorService.retrieveOperator(operator1.getIdOperateur());
        log.info(res.toString());
        Assertions.assertEquals(operator1,res);
    }

    @Test
    @Order(2)
    void retrieveAllOperators() {
        operatorService.addOperator(operator1);
        operatorService.addOperator(operator2);
        List<Operator> operatorList = operatorService.retrieveAllOperators();
        log.info(operatorList.toString());
        Assertions.assertEquals(2, operatorList.size());
    }

    @Test
    @Order(3)
    void deleteOperator() {
        operatorService.addOperator(operator1);
        operatorService.deleteOperator(operator1.getIdOperateur());
        Assertions.assertThrows(NullPointerException.class, () -> {
            operatorService.retrieveOperator(operator1.getIdOperateur());
        });
    }

    @Test
    @Order(4)
    void updateOperator() {
        operatorService.addOperator(operator1);
        operator1.setFname("updated1");
        operator1.setLname("updated2");
        operator1.setPassword("updated3");
        operatorService.updateOperator(operator1);
        Operator operatorUpdated = operatorService.retrieveOperator(operator1.getIdOperateur());
        log.info(operator1.toString());
        log.info(operatorUpdated.toString());
        Assertions.assertEquals(operatorUpdated.getFname(),"updated1");
        Assertions.assertEquals(operatorUpdated.getLname(),"updated2");
        Assertions.assertEquals(operatorUpdated.getPassword(),"updated3");
    }

}
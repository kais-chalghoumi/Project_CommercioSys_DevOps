package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.services.Iservices.IOperatorService;

import java.util.List;

//@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
class OperatorServiceImplJUnitTest {

    //@Autowired
    //IOperatorService operatorService;

    //    @Test
    //@Order(1)
    //void retrieveAllOperators() {
    //    Integer nbre = operatorService.retrieveAllOperators().size();
    //    List<Operator> operatorList = operatorService.retrieveAllOperators();
    //    Assertions.assertEquals(nbre, operatorList.size());
    //}

//    @Test
//    @Order(2)
//    void addOperator() {
//        Integer nbre = operatorService.retrieveAllOperators().size();
//        Operator operator = new Operator();
//        operatorService.addOperator(operator);
//        List<Operator> operatorList = operatorService.retrieveAllOperators();
//        Assertions.assertEquals(nbre+1, operatorList.size());
//    }

//    @Test
//    @Order(3)
//    void deleteOperator() {
//        Integer nbre = operatorService.retrieveAllOperators().size();
//        Long id = operatorService.findLastOperatorID();
//        operatorService.deleteOperator(id);
//        List<Operator> operatorList = operatorService.retrieveAllOperators();
//        Assertions.assertEquals(nbre-1, operatorList.size());
//    }

//    @Test
//    void updateOperator() {
//    }
//
//    @Test
//    void retrieveOperator() {
//    }

}
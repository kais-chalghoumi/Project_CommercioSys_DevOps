//package tn.esprit.devops_project.services;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import tn.esprit.devops_project.entities.Operator;
//import tn.esprit.devops_project.services.Iservices.IOperatorService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
//class OperatorServiceImplJUnitTest {
//
//    @Autowired
//    IOperatorService operatorService;
//
//    @Test
//    @Order(1)
//    void retrieveAllOperators() {
//        List<Operator> operatorList = operatorService.retrieveAllOperators();
//        Assertions.assertEquals(3, operatorList.size());
//    }
//
//    @Test
//    @Order(2)
//    void addOperator() {
//        int nbre = operatorService.retrieveAllOperators().size();
//        Operator operator = new Operator();
//        operatorService.addOperator(operator);
//        List<Operator> operatorList = operatorService.retrieveAllOperators();
//        Assertions.assertEquals(nbre+1, operatorList.size());
//        operatorService.deleteOperator(operator.getIdOperateur());
//    }
//
//    @Test
//    @Order(3)
//    void deleteOperator() {
//        Operator operator = new Operator();
//        operatorService.addOperator(operator);
//        int nbre = operatorService.retrieveAllOperators().size();
//        operatorService.deleteOperator(operator.getIdOperateur());
//        List<Operator> operatorList = operatorService.retrieveAllOperators();
//        Assertions.assertEquals(nbre-1, operatorList.size());
//    }
//
//    @Test
//    @Order(4)
//    void updateOperator() {
//        Operator operator = new Operator();
//        operatorService.addOperator(operator);
//        operator.setFname("fname1");
//        operator.setLname("lname1");
//        operator.setPassword("password1");
//        operatorService.updateOperator(operator);
//        Operator operatorUpdated = operatorService.retrieveOperator(operator.getIdOperateur());
//        Assertions.assertEquals(operatorUpdated.getFname(),"fname1");
//        Assertions.assertEquals(operatorUpdated.getLname(),"lname1");
//        Assertions.assertEquals(operatorUpdated.getPassword(),"password1");
//        operatorService.deleteOperator(operator.getIdOperateur());
//    }
//
//    @Test
//    @Order(5)
//    void retrieveOperator() {
//        Operator operator = new Operator();
//        operatorService.addOperator(operator);
//        List<Operator> list = new ArrayList<>();
//        list.add(operatorService.retrieveOperator(operator.getIdOperateur()));
//        Assertions.assertEquals(1,list.size());
//        operatorService.deleteOperator(operator.getIdOperateur());
//    }
//
//}
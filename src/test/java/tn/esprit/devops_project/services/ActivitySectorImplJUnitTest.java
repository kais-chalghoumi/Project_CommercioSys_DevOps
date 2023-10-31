package tn.esprit.devops_project.services;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.services.Iservices.IActivitySector;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ActivitySectorImplJUnitTest {

    @Autowired
    IActivitySector as;

    @Test
    @Order(1)
    void retrieveAllActivitySectors() {

    }

    @Test
    void addActivitySector() {
    }

    @Test
    void deleteActivitySector() {
    }

    @Test
    void updateActivitySector() {
    }

    @Test
    void retrieveActivitySector() {
    }
}
package tn.esprit.devops_project.services;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;
import java.util.List;
import tn.esprit.devops_project.entities.ActivitySector;


@SpringBootTest
@Slf4j
@TestMethodOrder(OrderAnnotation.class)
class ActivitySectorImplJUnitTest {

    @Autowired
    ActivitySectorImpl activitySectorService;



    ActivitySector activitySector1 =new ActivitySector (null,"act1","sec1",null);
    ActivitySector activitySector2 =new ActivitySector (null,"act2","sec2",null);


    @Test
    @Transactional
    @Order(2)
    void retrieveAllActivitySectors() {
        activitySectorService.addActivitySector(activitySector1);
        activitySectorService.addActivitySector(activitySector2);
        List<ActivitySector> activitySectorList = activitySectorService.retrieveAllActivitySectors();
        log.info(activitySectorList.toString());
        Assertions.assertEquals(2, activitySectorList.size());
    }

    @Test
    @Transactional
    @Order(0)
    void addActivitySector() {
        ActivitySector act = activitySectorService.addActivitySector(activitySector1);
        log.info(act.toString());
    }

    @Test
    @Transactional
    @Order(3)
    void deleteActivitySector() {
        activitySectorService.addActivitySector(activitySector1);
        activitySectorService.deleteActivitySector(activitySector1.getIdSecteurActivite());
        Assertions.assertEquals(activitySectorService.retrieveAllActivitySectors().size(),0);
    }

    @Test
    @Transactional
    @Order(4)
    void updateActivitySector() {

        activitySectorService.addActivitySector(activitySector1);
        activitySector1.setLibelleSecteurActivite("rose");
        activitySector1.setCodeSecteurActivite("baie");
        activitySectorService.updateActivitySector(activitySector1);
        ActivitySector actSecUpdated = activitySectorService.retrieveActivitySector(activitySector1.getIdSecteurActivite());
        log.info(activitySector1.toString());
        log.info(actSecUpdated.toString());
        Assertions.assertEquals(actSecUpdated.getLibelleSecteurActivite(),"rose");
        Assertions.assertEquals(actSecUpdated.getCodeSecteurActivite(),"baie");
    }

    @Test
    @Transactional
    @Order(1)
    void retrieveActivitySector() {
        activitySectorService.addActivitySector(activitySector1);
        ActivitySector act = activitySectorService.retrieveActivitySector(activitySector1.getIdSecteurActivite());
        log.info(act.toString());
        Assertions.assertEquals(activitySector1,act);
    }
}
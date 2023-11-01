package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ActivitySectorImplMockitoTest {

    @Mock
    ActivitySectorRepository activitySectorRepository;

    @InjectMocks
    ActivitySectorImpl activitySectorService;

    ActivitySector activitySector = new ActivitySector(1L,"touta","batta",null);

    List<ActivitySector> activitySectorList = new ArrayList<ActivitySector>(){
        {
            add(new ActivitySector(2L,"touta2","batta2",null));
            add(new ActivitySector(3L,"touta3","batta3",null));
        }
    };

    @Test
    void retrieveAllActivitySectors() {
        Mockito.when(activitySectorRepository.findAll()).thenReturn(activitySectorList);
        List<ActivitySector> actlist = activitySectorService.retrieveAllActivitySectors();
        Assertions.assertEquals(2,actlist.size());
    }

    @Test
    void addActivitySector() {
        Mockito.when(activitySectorRepository.save(Mockito.any(ActivitySector.class))).thenReturn(activitySector);
        ActivitySector sectoract = activitySectorService.addActivitySector(activitySector);
        Assertions.assertEquals(1L,sectoract.getIdSecteurActivite());
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
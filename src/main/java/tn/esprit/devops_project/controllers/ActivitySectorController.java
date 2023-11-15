package tn.esprit.devops_project.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.services.Iservices.IActivitySector;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/activitySector")
@CrossOrigin(origins = "http://localhost:4200")
public class ActivitySectorController {

    IActivitySector activitySectorService;

    @GetMapping("/retrieveAllActivitySectors")
    List<ActivitySector> retrieveAllActivitySectors(){
        return activitySectorService.retrieveAllActivitySectors();
    }

    @PostMapping("/addActivitySector")
    ActivitySector addActivitySector(@RequestBody ActivitySector activitySector){
        return activitySectorService.addActivitySector(activitySector);
    }

    @DeleteMapping("/deleteActivitySector/{id}")
    void deleteActivitySector(@PathVariable Long id){
        activitySectorService.deleteActivitySector(id);
    }

    @PutMapping("/updateActivitySector")
    ActivitySector updateActivitySector(@RequestBody ActivitySector activitySector){
        return activitySectorService.updateActivitySector(activitySector);
    }

    @GetMapping("/retrieveActivitySector/{id}")
    ActivitySector retrieveActivitySector(@PathVariable Long id){
        return activitySectorService.retrieveActivitySector(id);
    }
}

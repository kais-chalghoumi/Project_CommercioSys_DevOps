package tn.esprit.devops_project.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.devops_project.services.Iservices.IStockService;


@RestController
@AllArgsConstructor
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {

    IStockService stockService;



}

package com.org.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.demo.model.EMICaculation;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class Controller {

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculateEmi(@RequestBody EMICaculation calculation) {
        Double emiAmount = getEmiAmount(calculation);
        return ResponseEntity.ok(emiAmount);
    }

   
    public Double getEmiAmount(EMICaculation calculation) {
        double p = calculation.getLoanAmount();  
        double r = calculation.getRateOfIntrest() / 100 / 12; 
        double n = calculation.getNumberOfYears() * 12; 
        
        double power = Math.pow((1 + r), n);
        double emi = (p * r * power) / (power - 1);
        
        return emi;
    }
}

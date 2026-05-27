package com.example.insuranceservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewOffersController {

    @GetMapping("/viewOffers")
    public String offers() {

        return "Insurance Offers";
    }
}
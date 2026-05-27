package com.example.insuranceservice.controller;

import com.example.insuranceservice.model.Offer;
import com.example.insuranceservice.service.OfferService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewOffersController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/viewOffers")
    public List<Offer> offers() {

        return offerService.getOffers();
    }
}
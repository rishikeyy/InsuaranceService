package com.example.insuranceservice.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.example.insuranceservice.repository.OfferRepository;
import com.example.insuranceservice.model.Offer;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> getOffers() {

        return offerRepository.findAll();
    }
}
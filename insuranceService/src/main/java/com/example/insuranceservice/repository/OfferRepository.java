package com.example.insuranceservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.insuranceservice.model.Offer;

public interface OfferRepository
        extends MongoRepository<Offer, String> {
}
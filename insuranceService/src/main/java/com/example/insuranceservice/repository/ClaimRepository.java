package com.example.insuranceservice.repository;

import com.example.insuranceservice.model.InsuranceClaim;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClaimRepository
        extends MongoRepository<InsuranceClaim, String> {
}
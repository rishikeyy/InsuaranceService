package com.example.insuranceservice.repository;

import com.example.insuranceservice.model.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PolicyRepository
        extends MongoRepository<Policy, String> {

    Optional<Policy> findByPolicyIdAndUserId(
            String policyId,
            String userId
    );
}
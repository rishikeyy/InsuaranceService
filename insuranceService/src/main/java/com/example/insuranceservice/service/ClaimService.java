package com.example.insuranceservice.service;

import com.example.insuranceservice.model.InsuranceClaim;
import com.example.insuranceservice.model.Policy;
import com.example.insuranceservice.repository.ClaimRepository;
import com.example.insuranceservice.repository.PolicyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ClaimService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private ClaimRepository claimRepository;

    public String submitClaim(InsuranceClaim claim) {

        Optional<Policy> optionalPolicy =
                policyRepository.findByPolicyIdAndUserId(
                        claim.getPolicyId(),
                        claim.getUserId()
                );

        if (optionalPolicy.isEmpty()) {

            return "Policy not found for user";
        }

        Policy policy = optionalPolicy.get();

        if (!policy.isActive()) {

            return "Policy inactive";
        }

        LocalDate expiry =
                LocalDate.parse(policy.getExpiryDate());

        if (expiry.isBefore(LocalDate.now())) {

            return "Policy expired";
        }

        claim.setStatus("APPROVED");

        claimRepository.save(claim);

        return "Claim submitted successfully";
    }
}
package com.example.insuranceservice.controller;

import com.example.insuranceservice.model.InsuranceClaim;
import com.example.insuranceservice.service.ClaimService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InsuranceClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping("/insuranceClaim")
    public String submitClaim(
            @RequestBody InsuranceClaim claim) {

        return claimService.submitClaim(claim);
    }
}
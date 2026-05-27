package com.example.insuranceservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsuranceClaimController {

    @PostMapping("/insuranceClaim")
    public String claim() {

        return "Claim Submitted";
    }
}
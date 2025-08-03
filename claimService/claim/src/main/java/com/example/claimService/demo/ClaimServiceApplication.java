package com.example.claimService.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClaimServiceApplication {
//use Tessaract library for text extraction from image uploaded for claim
	public static void main(String[] args) {
		SpringApplication.run(ClaimServiceApplication.class, args);
	}

}

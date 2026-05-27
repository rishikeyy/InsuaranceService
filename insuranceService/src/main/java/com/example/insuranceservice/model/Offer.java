package com.example.insuranceservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "offers")
public class Offer {

    @Id
    private String offerId;

    private String offerName;

    private double premium;
}
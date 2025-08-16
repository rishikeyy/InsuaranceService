package com.example.claimService.demo.unitTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Service.ClaimService;
import domain.Service.EventPublisher;
import domain.model.ClaimDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class ClaimServiceTest {
    //EventPublisher mockeventPublisher=mock(EventPublisher.class);

    @Mock
    EventPublisher mockEventPublisher;
    @InjectMocks
    ClaimService claimService;

    String claimJson="{\n" +
            "  \"claimId\": \"CLM123456\",\n" +
            "  \"policyNumber\": \"POL987654\",\n" +
            "  \"claimType\": \"Health\",\n" +
            "  \"claimAmount\": 15000.75,\n" +
            "  \"incidentDescription\": \"Hospitalization due to minor surgery\",\n" +
            "  \"incidentDate\": \"2025-08-10\",\n" +
            "  \"reportedDate\": \"2025-08-12\",\n" +
            "  \"contactEmail\": \"john.doe@example.com\",\n" +
            "  \"contactPhone\": \"+919876543210\"\n" +
            "}";
    ObjectMapper mapper = new ObjectMapper();
    /*
    Note: java can handle parsing JSON into simple types like(string,int etc.),
    But, it can't handle conversion of LocalDate objects... so to handle it java provides modules like "jackson-datatype-jsr310"
    To register it use mapper.registerModule(new JavaTimeModule()) OR mapper.findAndRegisterModules();
    */
    mapper.registerModule(new JavaTimeModule());

    ClaimDto claimDto=mapper.readValue(claimJson, ClaimDto.class);

    @Test
    void submitClaim(){

    }
}

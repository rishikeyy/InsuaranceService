package com.example.claimService.demo.unitTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
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

    String claimJson= """
            {
              "claimId": "CLM123456",
              "policyNumber": "POL987654",
              "claimType": "Health",
              "claimAmount": 15000.75,
              "incidentDescription": "Hospitalization due to minor surgery",
              "incidentDate": "2025-08-10",
              "reportedDate": "2025-08-12",
              "contactEmail": "john.doe@example.com",
              "contactPhone": "+919876543210"
            }""";
    //ObjectMapper mmapper = new ObjectMapper();
    ObjectMapper mapper = JsonMapper.builder()
            .findAndAddModules()
            .build();
    /*
    Note: java can handle parsing JSON into simple types like(string,int etc.),
    But, it can't handle conversion of LocalDate objects... so to handle it java provides modules like "jackson-datatype-jsr310"
    To register it use mapper.registerModule(new JavaTimeModule()) OR mapper.findAndRegisterModules();
    */

    //mmapper.registerModule(new void JavaTimeModule());



    @Test
    void submitClaim() throws JsonProcessingException {
        try {
            ClaimDto claimDto=mapper.readValue(claimJson, ClaimDto.class);
            claimService.SubmitClaim(claimDto);
//            return mapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting DTO to JSON", e);
        }
    }
}

package domain.Service;

import domain.model.ClaimDto;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import port.in.SubmitClaimInterface;

import java.util.concurrent.CompletableFuture;

@Service
public class ClaimService implements SubmitClaimInterface {
    @Override
    public CompletableFuture<SendResult<String, String>> SubmitClaim(ClaimDto claimDto){
        //RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<String> response= restTemplate.postForEntity("http://localhost:8092/claimRequest",claimDto,String.class);
        String topic="Claim-submit";

        KafkaTemplate kafkaTemplate=new KafkaTemplate();


        return response;
    }
}

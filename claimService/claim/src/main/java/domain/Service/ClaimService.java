package domain.Service;

import domain.model.ClaimDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import port.in.SubmitClaimInterface;

import java.util.concurrent.CompletableFuture;

@Service
public class ClaimService implements SubmitClaimInterface {
    @Autowired
    private  EventPublisher eventPublisher;//outbound adapter injected
    @Override
    public CompletableFuture<SendResult<String, String>> SubmitClaim(ClaimDto claimDto){
        //RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<String> response= restTemplate.postForEntity("http://localhost:8092/claimRequest",claimDto,String.class);

        return eventPublisher.sendToKafka(claimDto);
    }
}

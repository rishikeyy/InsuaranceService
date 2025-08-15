package port.out;

import domain.model.ClaimDto;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;

import java.util.concurrent.CompletableFuture;

public interface ClaimEventPublisher {
    public CompletableFuture<SendResult<String, ClaimDto>> sendToKafka( ClaimDto message);

    //CompletableFuture<SendResult<String, ClaimDto>> SubmitClaim(ClaimDto message);
}

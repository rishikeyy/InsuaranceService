package port.in;

import org.springframework.http.ResponseEntity;
import  domain.model.ClaimDto;
import org.springframework.kafka.support.SendResult;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

//before taking claim check if user is logged in
public interface SubmitClaimInterface {
     CompletableFuture<SendResult<String, String>> SubmitClaim(ClaimDto claimDto);
}

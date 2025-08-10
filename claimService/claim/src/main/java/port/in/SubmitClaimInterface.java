package port.in;

import org.springframework.http.ResponseEntity;
import  domain.model.ClaimDto;
import java.net.http.HttpResponse;

//before taking claim check if user is logged in
public interface SubmitClaimInterface<String> {
     ResponseEntity<String> SubmitClaim(ClaimDto claimDto);
}

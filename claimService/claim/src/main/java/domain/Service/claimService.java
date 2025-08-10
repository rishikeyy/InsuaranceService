package domain.Service;

import domain.model.ClaimDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import port.in.SubmitClaimInterface;

@Service
public class claimService implements SubmitClaimInterface {
    @Override
    public ResponseEntity<String> SubmitClaim(ClaimDto claimDto){
        //just text for adding to secondbranch
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response= restTemplate.postForEntity("http://localhost:8092/claimRequest",claimDto,String.class);
        return response;
    }
}

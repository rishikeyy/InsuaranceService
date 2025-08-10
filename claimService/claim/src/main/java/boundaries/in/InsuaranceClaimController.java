package boundaries.in;

import domain.Service.ClaimService;
import domain.model.ClaimDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.CompletableFuture;

@Controller
public class InsuaranceClaimController {
    @Autowired
    public ClaimService claimService;

    @PostMapping("/submitClaim")
    public CompletableFuture<SendResult<String, String>> SubmitClaim(@Valid ClaimDto claimDto){
    return claimService.SubmitClaim(claimDto);
    }
}

package port.in;

import java.net.http.HttpResponse;

//before taking claim check if user is logged in
public interface SubmitClaimUseCase<T> {
    public HttpResponse<T> SubmitClaim();
}

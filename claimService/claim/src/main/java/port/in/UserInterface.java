package port.in;

import org.springframework.http.ResponseEntity;

import java.net.http.HttpResponse;

public interface UserInterface<T> {
    public ResponseEntity<String> CheckUser();
    //public HttpResponse<T> RegisterUser();
}

package port.in;

import domain.model.UserDto;
import org.springframework.http.ResponseEntity;

import java.net.http.HttpResponse;

public interface UserInterface<T> {
    public ResponseEntity<String> CheckUser(UserDto user);
    //public HttpResponse<T> RegisterUser();
}

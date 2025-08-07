package domain.Service;

import domain.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;

//Eureka for service discovery

@Service
public class UserService {
    public ResponseEntity<?> CheckUser(UserDto user){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response= restTemplate.postForEntity("http://localhost:8090",user,String.class);
        return response;
    }
}

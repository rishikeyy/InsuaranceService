package boundaries.in;

import  domain.Service.UserService;
import domain.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import port.in.UserInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.http.HttpResponse;

@Controller
public class UserController  {
    @Autowired
    public UserService userService;

    @PostMapping("/checkUser")
    public ResponseEntity<String> CheckUser(@RequestBody UserDto user){
        return userService.CheckUser(user);
    }


}

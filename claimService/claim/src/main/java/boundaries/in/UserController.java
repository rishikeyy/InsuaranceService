package boundaries.in;

import port.in.UserInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.http.HttpResponse;

@Controller
public class UserController implements UserInterface {

    @PostMapping("/checkUser")
    public HttpResponse<T> CheckUser(){

    }
}

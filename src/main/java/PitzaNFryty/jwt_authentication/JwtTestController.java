package PitzaNFryty.jwt_authentication;

import PitzaNFryty.customer.RegisteredUser.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtTestController {

    private final RegisteredUserRepository userRepository;

    @Autowired
    public JwtTestController(RegisteredUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/everyone")
    public String everyone(){
        return "Anyone can see this <3";
    }

    @GetMapping("/authenticated")
    public String authenticated(){
        return "Only for chosen ones";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Admin admin admin :)";
    }

    @GetMapping("/manager")
    public String manager(){
        return "Only manager's stuff. He can see you...";
    }
}

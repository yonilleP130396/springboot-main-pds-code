package javaman.EncryptData.UsersAccount;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping
    public String getUserProfile() {
        return "Administrator/User/index";
    }
    
}

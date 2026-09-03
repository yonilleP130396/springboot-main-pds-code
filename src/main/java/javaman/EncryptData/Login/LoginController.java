package javaman.EncryptData.Login;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping()
    public String LoginHandler(HttpServletRequest request) {
        String host = request.getHeader("Host");
        if (host != null && host.startsWith("10.10.1.15")) {
            return "redirect:https://nipmb.polaris-mil.ph:8543/login";
        }
       
        return "Administrator/CustomizeLogin/login";
    }
}
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
// https://dzone.com/articles/spring-mvc-example-for-user-registration-and-login-1

@Controller
public class Login {
    
    @RequestMapping("/login.htm")
//    @RequestMapping(method = RequestMethod.GET)
    public String Page() {
        return "login";
    }
    
//    @RequestMapping("/login.htm", method = RequestMethod.POST)
    
    
}
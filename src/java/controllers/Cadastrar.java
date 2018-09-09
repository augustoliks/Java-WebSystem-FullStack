package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller

public class Cadastrar {
    
    @RequestMapping("/cadastrar.htm")
    public String Page() {
        return "cadastro";
    }
}
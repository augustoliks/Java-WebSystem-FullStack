package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller

public class Index {
    
    @RequestMapping("/index.htm")
    public String Page() {
        return "index";
    }
    
    @RequestMapping("/todo.htm")
    public String todo() {
        return "todo";
    }
}
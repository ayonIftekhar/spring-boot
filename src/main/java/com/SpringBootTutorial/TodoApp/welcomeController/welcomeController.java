package com.SpringBootTutorial.TodoApp.welcomeController;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class welcomeController {

    @RequestMapping("")
    public String getWelcomePage(ModelMap modelMap){
        modelMap.put("username" , getUsername());
        return "welcome";
    }

    public String getUsername(){
        Authentication authentication =
                SecurityContextHolder.getContext()
                        .getAuthentication();
        return authentication.getName();
    }
}

package com.example.store;

import com.example.store.user.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String showHomePage(){
        return "index";
    }

    @GetMapping(value="contact")
    public String showContactPage(){
        return "contact";
    }
}

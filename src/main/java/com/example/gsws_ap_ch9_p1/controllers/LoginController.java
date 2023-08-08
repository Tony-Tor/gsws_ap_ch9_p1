package com.example.gsws_ap_ch9_p1.controllers;

import com.example.gsws_ap_ch9_p1.services.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class LoginController {

    private static Logger logger = Logger.getLogger(LoginController.class.getName());
    private final LoginProcessor processor;

    public LoginController(LoginProcessor loginProcessor) {
        logger.info("Контроллер логинов создан");
        this.processor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/") //??
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ){
        processor.setUsername(username);
        processor.setPassword(password);
        boolean loggedIn = processor.login();

        if(loggedIn) {
            model.addAttribute("message", "You are now logged in");
        } else {
            model.addAttribute("message", "Login failed!");
        }

        return "login.html";
    }
}

package com.example.gsws_ap_ch9_p1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }
}

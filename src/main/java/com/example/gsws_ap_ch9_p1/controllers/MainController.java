package com.example.gsws_ap_ch9_p1.controllers;

import com.example.gsws_ap_ch9_p1.services.LoggedUserManagementService;
import com.example.gsws_ap_ch9_p1.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;
    private static Logger logger = Logger.getLogger(MainController.class.getName());

    public MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService){
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String Logout, Model model) {
        if(Logout!=null){
            loggedUserManagementService.setUsername(null);
            logger.info("Logout = " + Logout);
        }
        int count = loginCountService.getCount();

        String username = loggedUserManagementService.getUsername();

        if( username == null) {
            return "redirect:/";
        }

        model.addAttribute("username", username);
        model.addAttribute("loginCount", count);

        return "main.html";
    }
}

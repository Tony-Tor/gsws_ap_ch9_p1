package com.example.gsws_ap_ch9_p1.services;

import com.example.gsws_ap_ch9_p1.controllers.LoginController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import java.util.logging.Logger;

@Component
@RequestScope
public class LoginProcessor {

    private static Logger logger = Logger.getLogger(LoginProcessor.class.getName());

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    private String username;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loginCountService = loginCountService;
        this.loggedUserManagementService = loggedUserManagementService;
        logger.info("Процессор логинов создан");
    }

    public boolean login(){
        loginCountService.increment();

        String username = this.getUsername();
        String password = this.getPassword();

        boolean loginResult = false;

        if ("natalie".equals(username) && "password".equals(password)) {
            loginResult = true;
            loggedUserManagementService.setUsername(username);
        }
        return loginResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

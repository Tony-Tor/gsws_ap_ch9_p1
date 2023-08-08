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

    private String username;
    private String password;

    public LoginProcessor() {
        logger.info("Процессор логинов создан");
    }

    public boolean login(){
        String username = this.getUsername();
        String password = this.getPassword();

        if ("natalie".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
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

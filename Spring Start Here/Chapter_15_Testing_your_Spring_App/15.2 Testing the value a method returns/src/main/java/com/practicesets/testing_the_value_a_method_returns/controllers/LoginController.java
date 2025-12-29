package com.practicesets.testing_the_value_a_method_returns.controllers;

import com.practicesets.testing_the_value_a_method_returns.processors.LoginProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final ApplicationContext applicationContext;

    public LoginController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        LoginProcessor loginProcessor = applicationContext.getBean(LoginProcessor.class);
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean loggedIn = loginProcessor.login();
        if (loggedIn)
            model.addAttribute("message", "You are now logged in!");
        else {
            model.addAttribute("message", "Login failed. Please try again.");
        }

        return "login.html";
    }
}

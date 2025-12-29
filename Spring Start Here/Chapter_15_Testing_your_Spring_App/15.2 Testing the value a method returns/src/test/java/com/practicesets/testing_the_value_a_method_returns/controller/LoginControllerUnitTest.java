package com.practicesets.testing_the_value_a_method_returns.controller;

import com.practicesets.testing_the_value_a_method_returns.controllers.LoginController;
import com.practicesets.testing_the_value_a_method_returns.processors.LoginProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoginControllerUnitTest {

    @Mock
    private Model model;

    @Mock
    private ApplicationContext applicationContext;

    @Mock
    private LoginProcessor loginProcessor;

    @InjectMocks
    private LoginController loginController;

    @Test
    public void loginPostLoginSucceedsTest() {
        when(applicationContext.getBean(LoginProcessor.class)).thenReturn(loginProcessor);
        when(loginProcessor.login()).thenReturn(true);
        String result = loginController.loginPost("username", "password", model);
        assertEquals("login.html", result);
        verify(loginProcessor).setUsername("username");
        verify(loginProcessor).setPassword("password");
        verify(model).addAttribute("message", "You are now logged in!");

    }

    @Test
    public void loginPostLoginFailsTest() {
        when(applicationContext.getBean(LoginProcessor.class)).thenReturn(loginProcessor);
        when(loginProcessor.login()).thenReturn(false);
        String result = loginController.loginPost("username", "password", model);
        assertEquals("login.html", result);
        verify(loginProcessor).setUsername("username");
        verify(loginProcessor).setPassword("password");
        verify(model).addAttribute("message", "Login failed. Please try again.");
    }
}

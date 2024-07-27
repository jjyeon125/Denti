package com.example.demo.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAuthController {

    @GetMapping("/user/login")
    public String showUserLogin() {
        return "user/login";
    }

    @GetMapping("/user/join")
    public String showUserJoin() {
        return "user/register";
    }
}
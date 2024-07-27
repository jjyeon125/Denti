package com.example.demo.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DentistAuthController {

    @GetMapping("/dentist/login")
    public String showDentistLogin() {
        return "Dentist/login";
    }

    @GetMapping("/dentist/join")
    public String showDentistJoin() {
        return "Dentist/register";
    }
}
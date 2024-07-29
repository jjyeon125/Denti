package com.example.demo.auth.controller;

import com.example.demo.dto.DentistDTO;
import com.example.demo.entity.Dentist;
import com.example.demo.auth.service.DentistAuthService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DentistAuthController {
    private final DentistAuthService dentistAuthService;
    private static final Logger logger = LoggerFactory.getLogger(DentistAuthController.class);

    @Autowired
    public DentistAuthController(DentistAuthService dentistAuthService) {
        this.dentistAuthService = dentistAuthService;
    }

    @GetMapping("/dentist/login")
    public String showDentistLogin() {
        return "Dentist/login";
    }

    @PostMapping("/dentist/login")
    public String dentistLogin(DentistDTO dentistDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        Dentist dentist = dentistAuthService.login(dentistDTO);

        if (dentist == null) {
            redirectAttributes.addFlashAttribute("loginError", "회원정보가 일치하지 않습니다.");
            return "redirect:/dentist/login";
        }

        session.setAttribute("dentist", dentist);
        session.setAttribute("dentistName", dentist.getDocName());
        logger.info("Dentist {} logged in and stored in session", dentist.getDocName());

        return "redirect:/";
    }

    @GetMapping("/dentist/join")
    public String showDentistJoin() {
        return "Dentist/register";
    }
}
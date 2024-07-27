package com.example.demo.login.controller;

import com.example.demo.dto.DentistDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Dentist;
import com.example.demo.entity.Users;
import com.example.demo.login.service.DentistService;
import com.example.demo.login.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    private final UserService userService;
    private final DentistService dentistService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public LoginController(UserService userService, DentistService dentistService) {
        this.userService = userService;
        this.dentistService = dentistService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(UserDTO userDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        Users user = userService.login(userDTO);

        if (user == null) {
            redirectAttributes.addFlashAttribute("loginError", "회원정보가 일치하지 않습니다.");
            return "redirect:/login";
        }

        session.setAttribute("user", user);
        logger.info("User {} logged in and stored in session");

        return "redirect:/";
    }

    @GetMapping("/dentist/login")
    public String dentistLoginForm() {
        return "dentist/login";
    }

    @PostMapping("/dentist/login")
    public String dentistLogin(DentistDTO dentistDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        Dentist dentist = dentistService.login(dentistDTO);

        if (dentist == null) {
            redirectAttributes.addFlashAttribute("loginError", "회원정보가 일치하지 않습니다.");
            return "redirect:/dentist/login";
        }

        session.setAttribute("dentist", dentist);
        logger.info("Dentist {} logged in and stored in session");

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
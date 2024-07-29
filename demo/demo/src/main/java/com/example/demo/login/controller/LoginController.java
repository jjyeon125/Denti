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
import org.springframework.ui.Model;
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
        session.setAttribute("userName", user.getUserName());
        logger.info("User {} logged in and stored in session", user.getUserName());

        return "redirect:/";
    }

    @GetMapping("/dentist/login/form")
    public String dentistLoginForm() {
        return "Dentist/login";
    }

    @PostMapping("/dentist/login/form")
    public String dentistLogin(DentistDTO dentistDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        Dentist dentist = dentistService.login(dentistDTO);

        if (dentist == null) {
            redirectAttributes.addFlashAttribute("loginError", "회원정보가 일치하지 않습니다.");
            return "redirect:/dentist/login/form";
        }

        session.setAttribute("dentist", dentist);
        session.setAttribute("dentistName", dentist.getDocName());
        logger.info("Dentist {} logged in and stored in session", dentist.getDocName());

        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "user/register";
    }

    @PostMapping("/register")
    public String register(UserDTO userDTO, Model model, RedirectAttributes redirectAttributes) {
        logger.info("Received registration request for user: {}", userDTO.getUserId());
        try {
            userService.register(userDTO);
            logger.info("User registered successfully: {}", userDTO.getUserId());
            redirectAttributes.addFlashAttribute("registerSuccess", "회원가입이 완료되었습니다.");
            return "redirect:/login";
        } catch (Exception e) {
            logger.error("Error during registration: ", e);
            model.addAttribute("registerError", e.getMessage());
            return "user/register";
        }
    }

    @GetMapping("/dentist/register")
    public String dentistRegisterForm(Model model) {
        model.addAttribute("dentistDTO", new DentistDTO());
        return "Dentist/register";
    }

    @PostMapping("/dentist/register")
    public String dentistRegister(DentistDTO dentistDTO, Model model, RedirectAttributes redirectAttributes) {
        logger.info("Received registration request for dentist: {}", dentistDTO.getDentistId());
        try {
            dentistService.register(dentistDTO);
            logger.info("Dentist registered successfully: {}", dentistDTO.getDentistId());
            redirectAttributes.addFlashAttribute("registerSuccess", "회원가입이 완료되었습니다.");
            return "redirect:/dentist/login";
        } catch (Exception e) {
            logger.error("Error during registration: ", e);
            model.addAttribute("registerError", e.getMessage());
            return "Dentist/register";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
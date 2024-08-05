package com.example.demo.login.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @GetMapping("/RegisterSuccess")
    public String showRegisterSuccessPage() {
        return "RegisterSuccess";
    }

    @PostMapping("/register")
    public String register(UserDTO userDTO, Model model, RedirectAttributes redirectAttributes) {
        logger.info("Attempting to register user: {}", userDTO);

        if (userDTO.getUserBirth() == null) {
            redirectAttributes.addFlashAttribute("error", "Birth date cannot be null");
            return "redirect:/register";
        }

        try {
            userService.register(userDTO);
            return "redirect:/RegisterSuccess";
        } catch (Exception e) {
            logger.error("Error registering user", e);
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/register";
        }
    }

    @PostMapping("/login")
    public String login(UserDTO userDTO, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        logger.info("Attempting to login user: {}", userDTO);

        Users user = userService.login(userDTO);
        if (user != null) {
            session.setAttribute("userName", user.getUserName());
            return "redirect:/Mypage";
        } else {
            redirectAttributes.addFlashAttribute("loginError", "Invalid username or password");
            return "redirect:/login";
        }
    }

    @GetMapping("/Mypage")
    public String showMypage(Model model, HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        model.addAttribute("userName", userName);
        return "Mypage";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

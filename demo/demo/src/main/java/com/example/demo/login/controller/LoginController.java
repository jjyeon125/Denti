package com.example.demo.login.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.login.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.logging.Logger;

@Controller
public class LoginController {
    private final UserService userService;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
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

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

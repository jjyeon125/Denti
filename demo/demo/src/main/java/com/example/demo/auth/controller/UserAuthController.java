package com.example.demo.auth.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.auth.service.UserAuthService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserAuthController {
    private final UserAuthService userAuthService;
    private static final Logger logger = LoggerFactory.getLogger(UserAuthController.class);

    @Autowired
    public UserAuthController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @GetMapping("/user/login")
    public String showUserLogin() {
        return "user/login";
    }

    @PostMapping("/user/login")
    public String userLogin(UserDTO userDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        Users user = userAuthService.login(userDTO);

        if (user == null) {
            redirectAttributes.addFlashAttribute("loginError", "회원정보가 일치하지 않습니다.");
            return "redirect:/user/login";
        }

        session.setAttribute("user", user);
        session.setAttribute("userName", user.getUserName());
        logger.info("User {} logged in and stored in session", user.getUserName());

        return "redirect:/";
    }

    @GetMapping("/user/join")
    public String showUserJoin() {
        return "user/register";
    }
}
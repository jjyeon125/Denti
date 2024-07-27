package com.example.demo.review.controller;


import com.example.demo.entity.Review;
import com.example.demo.reservation.Service.AppointmentService;
import com.example.demo.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/new/{appointmentId}")
    public String showReviewForm(@PathVariable Long appointmentId, Model model) {
        model.addAttribute("appointmentId", appointmentId);
        model.addAttribute("review", new Review());
        return "review-form";
    }

    @PostMapping
    public String createReview(@RequestParam Long appointmentId, @RequestParam String content, Model model) {
        reviewService.createReview(appointmentId, content);
        return "redirect:/dentists";
    }

    @GetMapping("/dentist/{dentistId}")
    public String viewReviewsForDentist(@PathVariable Long dentistId, Model model) {
        model.addAttribute("reviews", reviewService.getReviewsForDentist(dentistId));
        return "dentist-reviews";
    }
}

package com.example.demo.reservation.controller;


import com.example.demo.reservation.Service.DentistReservationService;
import com.example.demo.reservation.model.Dentist;
import com.example.demo.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Dentist")
public class DentistController {

    @Autowired
    private DentistReservationService dentistReservationService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public String listDentists(Model model) {
        List<Dentist> dentists = dentistReservationService.getAllDentist();
        model.addAttribute("dentists", dentists);
        return "dentist-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("dentist", new Dentist());
        return "dentist-form";
    }

    @PostMapping
    public String createOrUpdateDentist(@ModelAttribute Dentist dentist) {
        dentistReservationService.createDentist(dentist);
        return "redirect:/dentists";
    }

    @GetMapping("/{id}")
    public String viewDentist(@PathVariable Long id, Model model) {
        Dentist dentist = dentistReservationService.getDentistById(id);
        model.addAttribute("dentist", dentist);
        model.addAttribute("reviews", reviewService.getReviewsForDentist(id));
        return "doctor-view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Dentist dentist = dentistReservationService.getDentistById(id);
        model.addAttribute("dentist", dentist);
        return "dentist-form";
    }

    @GetMapping("/delete/{id}")
    public String deletedentist(@PathVariable Long id) {
        dentistReservationService.deleteDentist(id);
        return "redirect:/dentists";
    }

}

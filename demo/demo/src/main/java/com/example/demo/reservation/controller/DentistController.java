package com.example.demo.reservation.controller;


import com.example.demo.reservation.Service.DentistService;
import com.example.demo.reservation.model.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Dentist")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @GetMapping
    public String listDentists(Model model) {
        List<Dentist> dentists = dentistService.getAllDentist();
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
        dentistService.createDentist(dentist);
        return "redirect:/dentists";
    }

    @GetMapping("/{id}")
    public String viewDentist(@PathVariable Long id, Model model) {
        Dentist dentist = dentistService.getDentistById(id);
        model.addAttribute("dentist", dentist);
        return "dentist-view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Dentist dentist = dentistService.getDentistById(id);
        model.addAttribute("dentist", dentist);
        return "dentist-form";
    }

    @GetMapping("/delete/{id}")
    public String deletedentist(@PathVariable Long id) {
        dentistService.deleteDentist(id);
        return "redirect:/dentists";
    }
}

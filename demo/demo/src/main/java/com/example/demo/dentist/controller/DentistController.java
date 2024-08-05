package com.example.demo.dentist.controller;

import com.example.demo.dentist.service.DentistReservationService;
import com.example.demo.entity.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Dentist")
public class DentistController {

    @Autowired
    private DentistReservationService dentistReservationService;

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

    @GetMapping("/")
    public String index(Model model) {
        return "index"; // 메인 페이지
    }

    @GetMapping("/dentist")
    public String searchDentist(@RequestParam(required = false) String name,
                                @RequestParam(required = false) String category,
                                Model model) {
        List<Dentist> dentists;

        if (name != null && !name.isEmpty()) {
            dentists = dentistReservationService.searchDentistByName(name);
        } else if (category != null && !category.isEmpty()) {
            dentists = dentistReservationService.searchDentistByCategory(category);
        } else {
            dentists = List.of(); // 빈 리스트 반환
        }

        model.addAttribute("dentists", dentists);
        model.addAttribute("address", dentists.isEmpty() ? "" : dentists.get(0).getAddress());
        return "index"; // 검색 결과를 보여주는 페이지
    }
}
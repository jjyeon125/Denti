package com.example.demo.reservation.controller;


import com.example.demo.reservation.Service.DentistService;
import com.example.demo.reservation.model.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Dentist")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @GetMapping
    public List<Dentist> getAllDentist(){
        return dentistService.getAllDentist();
    }

    @PostMapping
    public Dentist createDentist(@RequestBody Dentist dentist){
        return dentistService.createDentist(dentist);
    }
}

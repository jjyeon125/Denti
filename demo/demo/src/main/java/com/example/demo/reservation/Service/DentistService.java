package com.example.demo.reservation.Service;

import com.example.demo.reservation.model.Dentist;
import com.example.demo.reservation.repository.DentistRepository;

import java.util.List;

public class DentistService {
    private DentistRepository dentistRepository;

    public List<Dentist> getAllDentis(){
        return dentistRepository.findAll();
    }
}

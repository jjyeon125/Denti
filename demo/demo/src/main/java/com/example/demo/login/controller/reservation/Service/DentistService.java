package com.example.demo.login.controller.reservation.Service;

import com.example.demo.login.controller.reservation.model.Dentist;
import com.example.demo.login.controller.reservation.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    public List<Dentist> getAllDentist() {
        return dentistRepository.findAll();
    }

    public Dentist createDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    public Dentist getDentistById(Long id) {
        return dentistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid dentist ID"));
    }

    public void deleteDentist(Long id) {
        dentistRepository.deleteById(id);
    }}

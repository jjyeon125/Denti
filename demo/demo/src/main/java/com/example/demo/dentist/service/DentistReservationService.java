package com.example.demo.dentist.service;

import com.example.demo.entity.Dentist;
import com.example.demo.dentist.repository.ReservationDentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistReservationService {

    @Autowired
    private ReservationDentistRepository reservationDentistRepository;

    public List<Dentist> getAllDentist() {
        return reservationDentistRepository.findAll();
    }

    public Dentist createDentist(Dentist dentist) {
        return reservationDentistRepository.save(dentist);
    }

    public Dentist getDentistById(Long id) {
        return reservationDentistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid dentist ID"));
    }

    public void deleteDentist(Long id) {
        reservationDentistRepository.deleteById(id);
    }

    public List<Dentist> searchDentistByName(String name) {
        return reservationDentistRepository.findByNameContaining(name);
    }

    public List<Dentist> searchDentistByCategory(String category) {
        return reservationDentistRepository.findByCategory(category);
    }



}

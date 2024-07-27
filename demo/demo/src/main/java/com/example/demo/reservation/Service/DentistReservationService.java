package com.example.demo.reservation.Service;

import com.example.demo.reservation.model.Dentist;
import com.example.demo.reservation.repository.ReservationDentistRepository;
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
    }}

package com.example.demo.reservation.Service;

import com.example.demo.reservation.model.Dentist;
import com.example.demo.reservation.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    public List<Dentist> getAllDentist(){
        return dentistRepository.findAll();
    }

    public Dentist createDentist(Dentist dentist){
        return dentistRepository.save(dentist);
    }
}

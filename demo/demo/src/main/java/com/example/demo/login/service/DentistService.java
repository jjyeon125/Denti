package com.example.demo.login.service;

import com.example.demo.dto.DentistDTO;
import com.example.demo.entity.Dentist;
import com.example.demo.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DentistService {
    private final DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public Dentist login(DentistDTO dentistDTO) {
        return dentistRepository.findByDocIdAndDocPwd(dentistDTO.getDocId(), dentistDTO.getDocPwd());
    }
}
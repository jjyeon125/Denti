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

    public void register(DentistDTO dentistDTO) throws Exception {
        if (dentistRepository.existsByDocId(dentistDTO.getDentistId())) {
            throw new Exception("이미 존재하는 아이디입니다.");
        }

        Dentist dentist = Dentist.builder()
                .docId(dentistDTO.getDentistId())
                .docPwd(dentistDTO.getPassword())
                .docName(dentistDTO.getName())
                .build();

        dentistRepository.save(dentist);
    }

    public Dentist login(DentistDTO dentistDTO) {
        return dentistRepository.findByDocIdAndDocPwd(dentistDTO.getDentistId(), dentistDTO.getPassword());
    }
}
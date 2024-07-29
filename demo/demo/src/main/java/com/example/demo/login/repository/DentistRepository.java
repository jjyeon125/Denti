package com.example.demo.repository;

import com.example.demo.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
    boolean existsByDocId(String docId);
    Dentist findByDocIdAndDocPwd(String docId, String docPwd);
}
package com.example.demo.dentist.repository;

import com.example.demo.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDentistRepository extends JpaRepository<Dentist, Long> {
    List<Dentist> findByNameContaining(String name);
    List<Dentist> findByCategory(String category);

}
package com.example.demo.reservation.repository;


import com.example.demo.reservation.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class DentistRepository implements JpaRepository<Dentist, Long> {
}

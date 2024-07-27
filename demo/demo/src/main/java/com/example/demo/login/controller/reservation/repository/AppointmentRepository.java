package com.example.demo.login.controller.reservation.repository;

import com.example.demo.login.controller.reservation.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByAppointmentDateTime(LocalDateTime appointmentDateTime);

}


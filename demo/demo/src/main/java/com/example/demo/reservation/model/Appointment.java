package com.example.demo.reservation.model;

import jakarta.persistence.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private  User user;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Dentist dentist;

    private LocalDateTime appointmentDateTime;

    // 생성자, getter, setter (생략)


    public Appointment() {
        // 기본 생성자
    }

    public Appointment(User user, Dentist dentist, LocalDateTime appointmentDateTime) {
        this.user = user;
        this.dentist = dentist;
        this.appointmentDateTime = appointmentDateTime;
    }
}
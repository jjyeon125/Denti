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
    @JoinColumn(name = "member_id", nullable = false)
    private  User user;

    @ManyToOne
    @JoinColumn(name = "denti_id", nullable = false)
    private Dentist dentist;

    private LocalDateTime appointmentDateTime;




    public Appointment() {
        // 기본 생성자
    }

    public Appointment(User user, Dentist dentist, LocalDateTime appointmentDateTime) {
        this.user = user;
        this.dentist = dentist;
        this.appointmentDateTime = appointmentDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
}
package com.example.demo.reservation.Service;

import com.example.demo.entity.Appointment;
import com.example.demo.reservation.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Assuming currentUserId is obtained from the security context or session
    private Long currentUserId = 1L; // Example value, replace with actual logic

    public Appointment createAppointment(Appointment appointment) {
        // user_id 값을 설정합니다.
        appointment.setUserId(currentUserId);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
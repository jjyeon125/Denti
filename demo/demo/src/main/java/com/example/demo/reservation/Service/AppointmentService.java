package com.example.demo.reservation.Service;

import com.example.demo.login.repository.LoginRepository;
import com.example.demo.reservation.dto.AppointmentRequestDTO;
import com.example.demo.reservation.model.Appointment;
import com.example.demo.reservation.model.Dentist;
import com.example.demo.reservation.repository.AppointmentRepository;
import com.example.demo.reservation.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private DentistRepository dentistRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment createAppointment(AppointmentRequestDTO requestDTO) {
        // Check if the appointment time is already booked
        if (isAppointmentTimeAlreadyBooked(requestDTO)) {
            throw new IllegalArgumentException("Appointment time is already booked");
        }

        User patient = LoginRepository.findById(requestDTO.getUsertId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));
        Dentist dentist = dentistRepository.findById(requestDTO.getDentistId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid doctor ID"));

        LocalDateTime appointmentDateTime = requestDTO.toAppointmentDateTime();

        Appointment appointment = new Appointment(patient, dentist, appointmentDateTime);
        return appointmentRepository.save(appointment);
    }

    private boolean isAppointmentTimeAlreadyBooked(AppointmentRequestDTO requestDTO) {
        LocalDateTime appointmentDateTime = requestDTO.toAppointmentDateTime();

        // Check if there is any existing appointment at the same time
        List<Appointment> appointments = appointmentRepository.findByAppointmentDateTime(appointmentDateTime);
        return !appointments.isEmpty();
    }
}


}

package com.example.demo.reservation.controller;

import com.example.demo.entity.Appointment;
import com.example.demo.reservation.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointment-form")
    public String showAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "Appointment/appointment-form";
    }

    @GetMapping("/appointments")
    public String listAppointments(Model model) {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointments);
        return "Appointment/appointments";
    }

    @PostMapping("/appointment-success")
    public String createAppointment(@ModelAttribute Appointment appointment, @ModelAttribute("appointmentDateTime") String appointmentDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        appointment.setAppointmentDateTime(LocalDateTime.parse(appointmentDateTime, formatter));
        appointmentService.createAppointment(appointment);
        return "Appointment/appointment-success"; // Ensure this view exists
    }
}
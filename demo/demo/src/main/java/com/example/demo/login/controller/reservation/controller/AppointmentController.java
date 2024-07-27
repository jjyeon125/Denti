package com.example.demo.login.controller.reservation.controller;


import com.example.demo.login.controller.reservation.Service.AppointmentService;
import com.example.demo.login.controller.reservation.model.Appointment;
import com.example.demo.login.controller.reservation.dto.AppointmentRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public String showAppointmentForm(Model model) {
        model.addAttribute("appointmentRequest", new AppointmentRequestDTO());
        return "appointment-form";
    }

    @PostMapping
    public String createAppointment(@Valid AppointmentRequestDTO requestDTO, Model model) {
        try {
            Appointment appointment = appointmentService.createAppointment(requestDTO);
            model.addAttribute("appointment", appointment);
            return "appointment-success"; // 예약 성공 후 페이지
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("appointmentRequest", requestDTO);
            return "appointment-form"; // 예약 실패 시 페이지
        }
    }
}

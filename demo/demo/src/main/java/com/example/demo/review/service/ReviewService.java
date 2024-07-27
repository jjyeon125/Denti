package com.example.demo.review.service;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Review;
import com.example.demo.reservation.repository.AppointmentRepository;
import com.example.demo.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Review createReview(Long appointmentId, String content) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid appointment ID"));
        Review review = new Review(appointment, content);
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsForDentist(Long doctorId) {
        return reviewRepository.findByAppointment_Dentist_Id(doctorId);
    }

}

package com.example.demo.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class AppointmentRequestDTO {

    private String userId;
    private Long dentistId;
    private int year;
    private int month;
    private int date;
    private int hour;
    private LocalTime time;
    private String description; // Add this property

    public AppointmentRequestDTO() {
    }

    public AppointmentRequestDTO(String userId, Long dentistId, int year, int month, int date, int hour, LocalTime time, String description) {
        this.userId = userId;
        this.dentistId = dentistId;
        this.year = year;
        this.month = month;
        this.date = date;
        this.hour = hour;
        this.time = time;
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getDentistId() {
        return dentistId;
    }

    public void setDentistId(Long dentistId) {
        this.dentistId = dentistId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime toAppointmentDateTime() {
        return LocalDateTime.of(year, month, date, hour, 0); // 분, 초는 0으로 설정
    }
}
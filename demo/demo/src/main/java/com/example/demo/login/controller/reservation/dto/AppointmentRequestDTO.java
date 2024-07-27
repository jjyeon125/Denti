package com.example.demo.login.controller.reservation.dto;

import java.time.LocalDateTime;

public class AppointmentRequestDTO {

        private Long userId;
        private Long dentistId;
        private int year;
        private int month;
        private int date;
        private int hour;


    public AppointmentRequestDTO() {
            // 기본 생성자
        }

        public AppointmentRequestDTO(Long userId, Long dentistId, int year, int month, int date, int hour) {
            this.userId = userId;
            this.dentistId = dentistId;
            this.year = year;
            this.month = month;
            this.date = date;
            this.hour = hour;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long patientId) {
            this.userId = patientId;
        }

        public Long getDentistId() {
            return dentistId;
        }

        public void setDentistId(Long dentistrId) {
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

        public LocalDateTime toAppointmentDateTime() {
            return LocalDateTime.of(year, month, date, hour, 0); // 분, 초는 0으로 설정
        }
    }
}

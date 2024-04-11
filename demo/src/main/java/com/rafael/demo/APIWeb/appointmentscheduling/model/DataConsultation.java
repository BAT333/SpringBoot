package com.rafael.demo.APIWeb.appointmentscheduling.model;

import com.rafael.demo.APIWeb.Doctor.model.Specialty;

import java.time.LocalDateTime;

public record DataConsultation(
        LocalDateTime localDateTime,
        Specialty specialist
) {
}

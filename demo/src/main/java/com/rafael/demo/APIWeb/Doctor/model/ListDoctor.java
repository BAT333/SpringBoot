package com.rafael.demo.APIWeb.Doctor.model;

import com.rafael.demo.APIWeb.Doctor.Doctor;

public record ListDoctor(
        Long id,
        String name,
        String email,
        String crm,
        Specialty specialty
) {
    public ListDoctor(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}

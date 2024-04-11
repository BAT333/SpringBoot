package com.rafael.demo.APIWeb.patient.model;

import com.rafael.demo.APIWeb.patient.Patient;

public record DataListPatient(
        Long id,
        String name,
        String email,
        String cpf
) {
    public DataListPatient(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}

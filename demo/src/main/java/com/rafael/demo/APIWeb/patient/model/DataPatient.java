package com.rafael.demo.APIWeb.patient.model;

import com.rafael.demo.APIWeb.Address.model.DataAddress;

public record DataPatient(
        String name,
        String cpf,
        String email,
        String telephone,
        DataAddress address
) {
}

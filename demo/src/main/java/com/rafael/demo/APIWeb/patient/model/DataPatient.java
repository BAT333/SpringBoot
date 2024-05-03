package com.rafael.demo.APIWeb.patient.model;

import com.rafael.demo.APIWeb.Address.model.DataAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DataPatient(
        @NotNull
        String name,
        @NotNull
        String cpf,
        @Email
        @NotNull
        String email,
        @NotNull
        String telephone,
        @NotNull
        @Valid
        DataAddress address
) {
}

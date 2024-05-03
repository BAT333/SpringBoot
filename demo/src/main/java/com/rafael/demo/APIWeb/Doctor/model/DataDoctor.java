package com.rafael.demo.APIWeb.Doctor.model;

import com.rafael.demo.APIWeb.Address.model.DataAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DataDoctor(

        @NotNull
        String name,
        @Email
        String email,
        @NotNull
        String telephone,
        @NotNull
        String crm,
        @NotNull
        Specialty specialty,
        @NotNull
        @Valid
        DataAddress address
) {
}

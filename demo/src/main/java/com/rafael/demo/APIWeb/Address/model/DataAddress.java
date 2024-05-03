package com.rafael.demo.APIWeb.Address.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public record DataAddress(
        @NotNull
        String street,
        @NotNull
        String number,
        @NotNull
        String complement,
        @NotNull
        String neighborhood,
        @NotNull
        String city,
        @NotNull
        String uf,
        @NotNull
        String zipCode

) {
}

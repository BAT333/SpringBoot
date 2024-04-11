package com.rafael.demo.APIWeb.Address.model;

import jakarta.persistence.Column;

public record DataAddress(
         String street,
         String number,
         String complement,
         String neighborhood,
         String city,
         String uf,
         String zipCode

) {
        }

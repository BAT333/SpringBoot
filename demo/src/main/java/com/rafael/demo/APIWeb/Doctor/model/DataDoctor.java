package com.rafael.demo.APIWeb.Doctor.model;

import com.rafael.demo.APIWeb.Address.model.DataAddress;

public record DataDoctor(

        String name,
        String email,
        String telephone,
        String crm,
        Specialty specialty,
        DataAddress address
) {
}

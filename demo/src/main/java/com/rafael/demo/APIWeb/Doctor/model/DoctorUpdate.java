package com.rafael.demo.APIWeb.Doctor.model;

import com.rafael.demo.APIWeb.Address.model.DataAddress;

public record DoctorUpdate(
        String name,
        String telephone,
        DataAddress address
        ) {
}

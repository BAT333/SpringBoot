package com.rafael.demo.APIWeb.patient.model;

import com.rafael.demo.APIWeb.Address.model.DataAddress;

public record DataUpdatePatient(
        String name,
        String telephone,
        DataAddress address

) {
}

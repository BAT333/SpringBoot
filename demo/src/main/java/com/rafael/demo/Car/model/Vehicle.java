package com.rafael.demo.Car.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Vehicle(
        @JsonAlias("TipoVeiculo")
        String vehicleType,
        @JsonAlias("Valor")
        String velues,
        @JsonAlias("Marca")
        String mark,
        @JsonAlias("Modelo")
        String model,
        @JsonAlias("AnoModelo")
        String yearModel,
        @JsonAlias("Combustivel")
        String fuel,
        @JsonAlias("CodigoFipe")
        String codeFipe,
        @JsonAlias("MesReferencia")
        String referenceMonth,
        @JsonAlias("SiglaCombustivel")
        String acronymFuel



) {
}

package com.rafael.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSeries(@JsonAlias("cep")
                         String zipCode,
                         @JsonAlias("logradouro")
                         String publicPlace,
                         @JsonAlias("complemento")
                         String complement,
                         @JsonAlias("bairro")
                         String neighborhood) {
}

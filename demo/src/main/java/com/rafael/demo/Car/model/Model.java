package com.rafael.demo.Car.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Model(

        @JsonAlias("codigo")
        String code,
        @JsonAlias("nome")
        String name

) {
}

package com.rafael.demo.Car.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Years(
        @JsonAlias("codigo")
        String code,
        @JsonAlias("nome")
        String name



) {
}

package com.rafael.demo.lambda.Car.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Mark(
        @JsonAlias("codigo")
        String code,
        @JsonAlias("nome")
        String year




        ) {
}

package com.rafael.demo.Car.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Models(
        @JsonAlias("modelos")
        List<Model> models,
        @JsonAlias("anos")
        List<Years> years

        )
{

}

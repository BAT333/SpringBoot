package com.rafael.demo.lambda.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataComplementary(
        @JsonAlias("ibge")
        String ibge,
        @JsonAlias("gia")
        String gia,
        @JsonAlias("siafi")
        String siafi


        ) {
}

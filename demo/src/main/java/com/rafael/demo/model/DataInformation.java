package com.rafael.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataInformation(
        @JsonAlias("uf")
        String state,
        @JsonAlias("localidade")
        String locality,
        @JsonAlias("ddd")
        String ddd


) {
}

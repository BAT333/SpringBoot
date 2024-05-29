package com.rafael.demo.lambda.Car.Class;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class MasterTest {

    private final ObjectMapper mapper = new ObjectMapper();
    @Test
    @DisplayName("Esta convertendo")
    void type(){
        String retornoEsperado ="DataInformation[state=SP, locality=São Paulo, ddd=11]";
        String json = this.getData("https://viacep.com.br/ws/08460-367/json/");
        String recebida = String.valueOf(this.converter(json, DataInformation.class));
        Assertions.assertEquals(retornoEsperado,recebida);
    }


    <T> T converter(String json, Class<T> t) {
        try {
            return mapper.readValue(json,t);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getData(String url){
        URI uri =  URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        String json;
        try {
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            json = response.body();
        }catch (InterruptedException | IOException ex){
            throw new RuntimeException(ex);
        }
        return json;
    }
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
}
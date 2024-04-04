package com.rafael.demo.persistenciaJava.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchingAPI {

    public String getDate(String uri){
        URI uris = URI.create(uri);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uris).build();
        HttpResponse<String> response;
        try {
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        }catch (InterruptedException | IOException ex){
            throw new RuntimeException(ex);
        }
        return response.body();
    }

}

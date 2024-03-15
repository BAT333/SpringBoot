package com.rafael.demo.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIconsumption {


    public String getData(String api){
        URI uri = URI.create(api);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request,HttpResponse.BodyHandlers.ofString());

        }catch (InterruptedException | IOException ex){
            throw new RuntimeException(ex);
        }
        String json = response.body();
        return json;
    }

}

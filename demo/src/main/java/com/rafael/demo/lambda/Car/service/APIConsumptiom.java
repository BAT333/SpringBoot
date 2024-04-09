package com.rafael.demo.lambda.Car.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConsumptiom {


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

}

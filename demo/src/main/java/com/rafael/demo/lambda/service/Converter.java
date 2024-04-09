package com.rafael.demo.lambda.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter implements IConverter{
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T dataConverter(String json, Class<T> tClass) {

        try {
            return mapper.readValue(json,tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

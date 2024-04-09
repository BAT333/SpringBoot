package com.rafael.demo.lambda.Car.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.util.List;

public class Converter implements IConverter{
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T converter(String json, Class<T> t) {
        try {
            return mapper.readValue(json,t);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> listDate(String json, Class<T> t) {
        CollectionType list = mapper.getTypeFactory().constructCollectionType(List.class,t);
        try {
            return mapper.readValue(json,list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

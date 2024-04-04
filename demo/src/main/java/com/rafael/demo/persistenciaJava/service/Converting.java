package com.rafael.demo.persistenciaJava.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class Converting implements IConverting {
   private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T convertingAPI(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json,tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> convertingListAPI(String json, Class<T> tClass) {
        CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class,tClass);
        try {
            return mapper.readValue(json,type);

        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}

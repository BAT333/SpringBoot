package com.rafael.demo.persistenciaJava.service;

import java.util.List;

public interface IConverting {
    public <T> T convertingAPI(String json,Class<T> tClass);
    public <T> List<T> convertingListAPI(String json, Class<T> tClass);
}

package com.rafael.demo.lambda.Car.service;

import java.util.List;

public interface IConverter {
    public <T> T converter(String json,Class<T> t);
    public <T> List<T> listDate(String json, Class<T> t);
}

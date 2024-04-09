package com.rafael.demo.lambda.service;

public interface IConverter {

    <T> T dataConverter(String json,Class<T> tClass);
}

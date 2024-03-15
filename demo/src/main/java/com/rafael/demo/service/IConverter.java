package com.rafael.demo.service;

public interface IConverter {

    <T> T dataConverter(String json,Class<T> tClass);
}

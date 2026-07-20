package com.ironhack.lab_java_springboot_rest_api_es.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String name) {
        super("Product with name " + name + " not found.");
    }
}

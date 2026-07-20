package com.ironhack.lab_java_springboot_rest_api_es.exception;

public class APIKeyNotFoundException extends RuntimeException {
    public APIKeyNotFoundException(String apiKey) {
        super("API-Key " + apiKey + " not found.");
    }
}

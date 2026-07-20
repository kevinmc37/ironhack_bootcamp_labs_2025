package com.ironhack.lab_java_springboot_rest_api_es.exception;

public class PriceRangeNotValidException extends RuntimeException {
    public PriceRangeNotValidException(double price1, double price2) {
        super("Invalid price range: " + price1 + ", " + price2);
    }
}

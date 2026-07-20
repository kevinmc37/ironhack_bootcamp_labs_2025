package com.ironhack.lab_java_springboot_fundamentals_es.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class WeatherService {

    public int getTemperature() {
        Random random = new Random();
        return random.nextInt(51) - 10; // Number between 0 and 50, - 10
    }

    public String getCondition() {
        Random random = new Random();
        int condition = random.nextInt(4); // Number between 0 and 3
        switch (condition) {
            case 1 -> {
                return "Sunny";
            }
            case 2 -> {
                return "Rainy";
            }
            case 3 -> {
                return "Cloudy";
            }
            default -> {
                return "Windy";
            }
        }
    }

    public int getWind() {
        Random random = new Random();
        return random.nextInt(101); // Number between 0 and 100
    }
}

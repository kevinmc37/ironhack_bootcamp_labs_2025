package com.ironhack.lab_java_springboot_fundamentals_es.controller;

import com.ironhack.lab_java_springboot_fundamentals_es.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/temperature")
    public int getTemperature() { return weatherService.getTemperature(); }

    @GetMapping("/condition")
    public String getCondition() { return weatherService.getCondition(); }

    @GetMapping("/wind")
    public int getWind() { return weatherService.getWind(); }
}

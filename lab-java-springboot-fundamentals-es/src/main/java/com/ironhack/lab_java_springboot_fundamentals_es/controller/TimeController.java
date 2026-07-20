package com.ironhack.lab_java_springboot_fundamentals_es.controller;

import com.ironhack.lab_java_springboot_fundamentals_es.service.TimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/time")
public class TimeController {
    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping()
    public LocalTime getTime() { return timeService.getTime(); }

    @GetMapping("/date")
    public LocalDate getDate() { return timeService.getDate(); }

    @GetMapping("/day")
    public String getDay() { return timeService.getDay(); }

    @GetMapping("/all")
    public String getAll() { return timeService.getAll(); }
}

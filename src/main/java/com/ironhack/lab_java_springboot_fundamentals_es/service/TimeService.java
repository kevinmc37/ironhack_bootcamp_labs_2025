package com.ironhack.lab_java_springboot_fundamentals_es.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeService {

    public LocalTime getTime() {
        return LocalTime.now();
    }

    public LocalDate getDate() {
        return LocalDate.now();
    }

    public String getDay() {
        return dayFormatter(false);
    }

    public String getAll() {
        return dayFormatter(true);
    }

    private String dayFormatter(boolean all) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dayFormat;
        String day;
        String format = dateTime.format(DateTimeFormatter.ofPattern("E"));
        switch (format) {
            case "lun" -> day = "Lunes, ";
            case "mar" -> day = "Martes, ";
            case "mié" -> day = "Miércoles, ";
            case "jue" -> day = "Jueves, ";
            case "vie" -> day = "Viernes, ";
            case "sáb" -> day = "Sábado, ";
            default -> day = "Domingo, ";
        }
        if (all) {
            dayFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        }
        else {
            dayFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        }
        return day + dateTime.format(dayFormat);
    }
}

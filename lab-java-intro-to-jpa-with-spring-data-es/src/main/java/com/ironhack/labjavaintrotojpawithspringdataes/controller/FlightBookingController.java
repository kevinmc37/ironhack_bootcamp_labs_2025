package com.ironhack.labjavaintrotojpawithspringdataes.controller;

import com.ironhack.labjavaintrotojpawithspringdataes.model.FlightBooking;
import com.ironhack.labjavaintrotojpawithspringdataes.service.FlightBookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class FlightBookingController {
    private final FlightBookingService flightBookingService;

    public FlightBookingController(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    @GetMapping("/customer")
    public List<FlightBooking> getBookingByCustomerId(@RequestParam int id) {
        return flightBookingService.getBookingByCustomerId(id);
    }

    @GetMapping("/flight")
    public List<FlightBooking> getBookingByFlightId(@RequestParam int id) {
        return flightBookingService.getBookingByFlightId(id);
    }
}

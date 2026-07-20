package com.ironhack.labjavaintrotojpawithspringdataes.service;

import com.ironhack.labjavaintrotojpawithspringdataes.model.FlightBooking;
import com.ironhack.labjavaintrotojpawithspringdataes.repository.FlightBookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightBookingService {
    private final FlightBookingRepository flightBookingRepository;

    public FlightBookingService(FlightBookingRepository flightBookingRepository) {
        this.flightBookingRepository = flightBookingRepository;
    }

    public List<FlightBooking> getBookingByCustomerId(int id) {
        return flightBookingRepository.findByCustomerId(id);
    }

    public List<FlightBooking> getBookingByFlightId(int id) {
        return flightBookingRepository.findByFlightId(id);
    }
}

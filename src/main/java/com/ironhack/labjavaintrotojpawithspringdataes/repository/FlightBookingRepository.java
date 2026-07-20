package com.ironhack.labjavaintrotojpawithspringdataes.repository;

import com.ironhack.labjavaintrotojpawithspringdataes.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
    List<FlightBooking> findByCustomerId(int customerId);
    List<FlightBooking> findByFlightId(int flightId);
}

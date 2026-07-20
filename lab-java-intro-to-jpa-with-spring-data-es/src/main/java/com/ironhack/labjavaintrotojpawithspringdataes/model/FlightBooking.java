package com.ironhack.labjavaintrotojpawithspringdataes.model;

import jakarta.persistence.*;

@Entity
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int customerId;

    @Column(nullable = false)
    private int flightId;

    public FlightBooking() {}

    public FlightBooking(int id, int customerId, int flightId) {
        setId(id);
        setCustomerId(customerId);
        setFlightId(flightId);
    }

    public int getId() { return id; }

    public int getCustomerId() { return customerId; }

    public int getFlightId() { return flightId; }

    public void setId(int id) { this.id = id; }

    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public void setFlightId(int flightId) { this.flightId = flightId; }
}

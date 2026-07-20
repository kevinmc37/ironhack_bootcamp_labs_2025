package com.ironhack.labjavaintrotojpawithspringdataes.model;

import jakarta.persistence.*;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String aircraft;

    @Column(nullable = false)
    private int seats;

    @Column(nullable = false)
    private int mileage;

    public Flight() {}

    public Flight(int id, String number, String aircraft, int seats, int mileage) {
        setId(id);
        setNumber(number);
        setAircraft(aircraft);
        setSeats(seats);
        setMileage(mileage);
    }

    public int getId() { return id; }

    public String getNumber() { return number; }

    public String getAircraft() { return aircraft; }

    public int getSeats() { return seats; }

    public int getMileage() { return mileage; }

    public void setId(int id) { this.id = id; }

    public void setNumber(String number) { this.number = number; }

    public void setAircraft(String aircraft) { this.aircraft = aircraft; }

    public void setSeats(int seats) { this.seats = seats; }

    public void setMileage(int mileage) { this.mileage = mileage; }
}

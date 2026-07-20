package com.ironhack.labjavaintrotojpawithspringdataes.model;

import com.ironhack.labjavaintrotojpawithspringdataes.enums.CustomerStatus;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    @Column(nullable = false)
    private int mileage;

    public Customer() {}

    public Customer(int id, String name, CustomerStatus status, int mileage) {
        setId(id);
        setName(name);
        setStatus(status);
        setMileage(mileage);
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public CustomerStatus getStatus() { return status; }

    public int getMileage() { return mileage; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setStatus(CustomerStatus status) { this.status = status; }

    public void setMileage(int mileage) { this.mileage = mileage; }
}

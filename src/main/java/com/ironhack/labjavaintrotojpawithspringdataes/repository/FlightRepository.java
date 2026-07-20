package com.ironhack.labjavaintrotojpawithspringdataes.repository;

import com.ironhack.labjavaintrotojpawithspringdataes.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {}

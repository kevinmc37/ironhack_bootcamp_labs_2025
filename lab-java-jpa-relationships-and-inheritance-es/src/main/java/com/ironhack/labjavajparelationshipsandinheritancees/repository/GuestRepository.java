package com.ironhack.labjavajparelationshipsandinheritancees.repository;

import com.ironhack.labjavajparelationshipsandinheritancees.enums.guestStatus;
import com.ironhack.labjavajparelationshipsandinheritancees.model.EventManagement.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(guestStatus status);
}

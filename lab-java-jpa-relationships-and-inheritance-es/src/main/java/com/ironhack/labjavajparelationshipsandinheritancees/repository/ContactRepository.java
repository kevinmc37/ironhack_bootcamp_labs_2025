package com.ironhack.labjavajparelationshipsandinheritancees.repository;

import com.ironhack.labjavajparelationshipsandinheritancees.model.PublicRelations.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {}

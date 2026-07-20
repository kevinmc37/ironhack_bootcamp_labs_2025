package com.ironhack.labjavajparelationshipsandinheritancees.model.TaskManagement;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class InternalTask extends Task {}

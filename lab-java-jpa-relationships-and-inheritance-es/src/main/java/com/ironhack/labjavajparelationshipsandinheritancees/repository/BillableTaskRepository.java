package com.ironhack.labjavajparelationshipsandinheritancees.repository;

import com.ironhack.labjavajparelationshipsandinheritancees.model.TaskManagement.BillableTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillableTaskRepository extends JpaRepository<BillableTask, Long> {}

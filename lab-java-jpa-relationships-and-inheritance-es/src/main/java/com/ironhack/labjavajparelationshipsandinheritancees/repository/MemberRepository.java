package com.ironhack.labjavajparelationshipsandinheritancees.repository;

import com.ironhack.labjavajparelationshipsandinheritancees.model.Association.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {}

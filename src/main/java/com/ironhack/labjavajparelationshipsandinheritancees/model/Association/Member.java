package com.ironhack.labjavajparelationshipsandinheritancees.model.Association;

import com.ironhack.labjavajparelationshipsandinheritancees.enums.memberStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private memberStatus status;

    @NotNull
    private LocalDate renewalDate;

    @ManyToMany(mappedBy = "members", fetch = FetchType.LAZY)
    private List<Division> divisions;
}

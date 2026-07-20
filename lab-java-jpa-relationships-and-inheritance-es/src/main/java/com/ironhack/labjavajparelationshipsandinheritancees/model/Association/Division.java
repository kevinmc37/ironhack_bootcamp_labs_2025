package com.ironhack.labjavajparelationshipsandinheritancees.model.Association;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String district;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "president_id")
    private Member president;

    @ManyToMany(mappedBy = "divisions", fetch = FetchType.LAZY)
    private List<Member> members;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "association_id")
    private Association association;
}

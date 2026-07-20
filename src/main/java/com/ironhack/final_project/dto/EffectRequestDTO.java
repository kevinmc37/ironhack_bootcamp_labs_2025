package com.ironhack.final_project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EffectRequestDTO {
    @NotBlank
    private String name;

    private String description;
    private int turns;
}

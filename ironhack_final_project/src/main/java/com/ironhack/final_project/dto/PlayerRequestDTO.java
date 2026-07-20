package com.ironhack.final_project.dto;

import com.ironhack.final_project.model.Effect;
import com.ironhack.final_project.model.Inventory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRequestDTO {
    @NotBlank
    private String name;

    private int health;
    private int attack;
    private int defense;
    private int speed;

    @NotNull
    private Inventory inventory;

    @PositiveOrZero
    private long gold;

    private double weight;
    private List<Effect> status = new ArrayList<>();
}

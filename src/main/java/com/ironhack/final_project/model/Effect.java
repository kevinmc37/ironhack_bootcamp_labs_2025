package com.ironhack.final_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Entity
public class Effect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long effectId;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @PositiveOrZero
    private int turns;

    @ManyToMany(mappedBy = "effect")
    private List<Item> items = new ArrayList<>();

    @ManyToMany(mappedBy = "status")
    private List<Player> players = new ArrayList<>();

    public String slowTarget(Player player, int speed_debuff, int turns) {
        if (turns == 0) {
            setTurns(turns);
            return player.getName() + "'s speed reduced by " + speed_debuff +
                    " for " + getTurns() + " seconds";
        }
        else {
            setTurns(0);
            return player.getName() + " is already slowed.";
        }
    }
}

package com.ironhack.final_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @NotBlank
    private String name;

    @Positive
    private int quantity;

    @Positive
    private int price;

    @PositiveOrZero
    private double weight;

    @NotBlank
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "item_effects",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "effect_id"))
    private List<Effect> effect = new ArrayList<>();

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    @Cascade({CascadeType.REFRESH, CascadeType.MERGE})
    private List<Inventory> inventory = new ArrayList<>();

    @ManyToMany
    @Cascade({CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "item_recipes",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "items_used_id"))
    private List<Item> recipes = new ArrayList<>();

    public void setAdditionalDescription() {
        String description = "\nCantidad: " + this.getQuantity() +
                "\nPrecio: " + this.getPrice() + "\nPeso: " + this.getWeight();
        this.setDescription(this.getDescription() + description);
    }

    public void useItem(Player player) {
        //TODO
    }
}
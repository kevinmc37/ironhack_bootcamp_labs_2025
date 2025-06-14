package com.ironhack.final_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
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
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @Positive
    private int space;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "inventory_items",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @OneToOne(mappedBy = "inventory")
    private Player player;

    public double getWeight() {
        double weight = 0;
        for (Item item : items) {
            weight += item.getWeight();
        }
        return weight;
    }

    public void order() {
        //TODO
    }
}

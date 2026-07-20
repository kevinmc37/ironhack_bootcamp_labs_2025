package com.ironhack.final_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@PrimaryKeyJoinColumn(name = "itemId")
public class Resource extends Item {
    @ManyToMany(mappedBy = "recipes")
    @Cascade({CascadeType.REFRESH, CascadeType.MERGE})
    private List<Item> usedInRecipe = new ArrayList<>();

    public Item combineResource(List<Resource> resources) {
        //TODO
        return null;
    }
}

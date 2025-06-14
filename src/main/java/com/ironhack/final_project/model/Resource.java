package com.ironhack.final_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@PrimaryKeyJoinColumn(name = "itemId")
public class Resource extends Item {
    private List<Item> recipe;

    public Item combineResource(List<Resource> resources) {
        //TODO
        return null;
    }
}

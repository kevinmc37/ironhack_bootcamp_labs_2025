package com.ironhack.final_project.model;

import jakarta.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name = "inventoryId")
public class Market extends Inventory {
    public void searchItem(Item item) {
        //TODO
    }

    public void buyItem(Item item) {
        //TODO
    }

    public void sellItem(Item item) {
        //TODO
    }
}

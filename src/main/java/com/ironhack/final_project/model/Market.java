package com.ironhack.final_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "inventoryId")
public class Market extends Inventory {
    public Item searchItem(Inventory inventory, String name) {
        for (Item item : inventory.getItems()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public boolean updateItemQuantity(Inventory inventory, String name, int quantity) {
        Item inventoryItem = searchItem(inventory, name);
        if (inventoryItem != null) {
            inventoryItem.setQuantity(quantity);
            return true;
        }
        return false;
    }

    public void buyItem(Item itemToBuy, Player player, int quantity) {
        Inventory marketInventory = this;
        Item marketItem = searchItem(marketInventory, itemToBuy.getName());
        String itemName = "";
        int itemPrice = 0;
        int newMarketQuantity = -1;
        int newPlayerQuantity = 0;
        if (marketItem != null) {
            int originalQuantity = marketItem.getQuantity();
            newMarketQuantity = originalQuantity - quantity;
            newPlayerQuantity = originalQuantity + quantity;
            itemPrice = marketItem.getPrice();
            itemName = marketItem.getName();
        }
        if (newMarketQuantity >= 0) {
            int newPrice = itemPrice * quantity;
            if (player.getGold() >= newPrice) {
                Inventory playerInventory = player.getInventory();
                Player system = this.getPlayer();
                boolean isUpdated;
                isUpdated = updateItemQuantity(playerInventory, itemName, newPlayerQuantity);
                if (!isUpdated) {
                    marketItem.setQuantity(quantity);
                    playerInventory.getItems().add(marketItem);
                }
                if (newMarketQuantity == 0) {
                    marketInventory.getItems().remove(marketItem);
                }
                else {
                    updateItemQuantity(marketInventory, itemName, newMarketQuantity);
                }
                player.setGold(player.getGold() - newPrice);
                system.setGold(system.getGold() + newPrice);
            }
            else {
                System.out.println("No tienes suficiente oro.");
            }
        }
        else {
            System.out.println("No hay stock suficiente.");
        }
    }

    public void sellItem(Item item) {
        //TODO
    }
}

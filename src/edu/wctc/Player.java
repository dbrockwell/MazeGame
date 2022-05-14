package edu.wctc;

import java.util.*;

public class Player {
    private int score;
    private HashMap<String, Integer> inventory = new HashMap<String, Integer>();

    public int getScore() {
        return score;
    }

    public HashMap<String, Integer> getInventory() {
        return inventory;
    }

    public String getFormattedInventory() {
        if (getInventory().size() != 0) {
            StringBuilder inventoryBuild = new StringBuilder();
            for (String i : inventory.keySet()) {
                inventoryBuild.append(i);
                inventoryBuild.append(" [");
                inventoryBuild.append(inventory.get(i));
                inventoryBuild.append("]");
                inventoryBuild.append(" :: ");
            }
            return inventoryBuild.toString();
        }
        else {
            return "Inventory is empty";
        }
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public void addToInventory(String item) {
        if (inventory.containsKey(item)) {
            inventory.replace(item, inventory.get(item) + 1);
        }
        else {
            inventory.put(item, 1);
        }
    }

    public void replaceInventoryItem(String toReplace, String replaceWith) {
        inventory.remove(toReplace);
        inventory.put(replaceWith, 1);
    }
}

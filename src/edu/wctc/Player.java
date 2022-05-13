package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int score;
    private List<String> inventory = new ArrayList<>();

    public int getScore() {
        return score;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public String getFormattedInventory() {
        if (getInventory().size() != 0) {
            StringBuilder inventoryBuild = new StringBuilder();
            for (int i = 0; i < getInventory().size(); i++) {
                inventoryBuild.append(getInventory().get(i));
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
        inventory.add(item);
    }

    public void replaceInventoryItem(String toReplace, String replaceWith) {
        inventory.set(inventory.indexOf(toReplace), replaceWith);
    }
}

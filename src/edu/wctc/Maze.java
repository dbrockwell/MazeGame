package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private Room currentRoom;
    private Player player;
    private boolean isFinished;

    public Maze(Player player) {
        this.player = player;
    }

    public String ExitCurrentRoom() {
        if (currentRoom.getExit() != null) {
            isFinished = true;
            return currentRoom.getExit();
        }
        else {
            return "You can not exit the cave here";
        }
    }

    public String InteractCurrentRoom() {
        if (currentRoom.getInteract() != null) {
            return currentRoom.getInteract();
        }
        else {
            return "You can not interact with the current room";
        }
    }

    public String LootCurrentRoom(String name, int score) {
        if (currentRoom.getLoot() != null) {
            if (name != null) {
                player.addToInventory(name);
                player.addToScore(score);
                return currentRoom.getLoot();
            }
            else {
                return currentRoom.noLoot();
            }
        }
        else {
            return "You can not loot the current room";
        }
    }

    public boolean Move(char direction) {
        if (currentRoom.getAdjoiningRoom(direction) != null) {
            currentRoom = currentRoom.getAdjoiningRoom(direction);
            return true;
        }
        else {return false;}
    }

    public boolean isFinished() {
        return isFinished;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}

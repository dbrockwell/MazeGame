package edu.wctc;

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

    public String LootCurrentRoom() {
        if (currentRoom.getLoot() != null) {
            return currentRoom.getLoot();
        }
        else {
            return "You can not loot the current room";
        }
    }
}

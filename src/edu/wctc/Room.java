package edu.wctc;

public class Room implements Interactable, Lootable, Exitable {
    private String name;
    private String description;
    private String interact = null;
    private String loot = null;
    private String exit = null;

    private Room further;
    private Room back;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setInteract(String interact) {
        this.interact = interact;
    }

    public void setLoot(String loot) {
        this.loot = loot;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    @Override
    public String getExit() {
        return exit;
    }

    @Override
    public String getInteract() {
        return interact;
    }

    @Override
    public String getLoot() {
        return loot;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getAdjoiningRoom(char direction) {
        if (direction == 'f') {
            return further;
        }
        else if (direction == 'b') {
            return back;
        }
        else {
            return null;
        }
    }

    public String getExits() {
        if (further != null && back != null) {
            return "You can go further or you can go back";
        }
        else if (further != null) {
            return "You can go further but you can't go back";
        }
        else if (back != null) {
            return "You can go back but you can't go any further";
        }
        else {
            return "There are no exits";
        }
    }

    public void setFurther(Room further) {
        this.further = further;
    }

    public void setBack(Room back) {
        this.back = back;
    }

    public String noLoot() {
        return "Room has been looted";
    }

    public String noInteract() {
        return "You can no longer interact with this room";
    }
}

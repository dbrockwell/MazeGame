package edu.wctc;

public class Room implements Interactable, Lootable, Exitable {
    private String name;
    private String description;
    private String interact = null;
    private String loot = null;
    private String exit = null;
    private String interactUnable = null;
    private String lootUnable = null;
    private String exitUnable = null;
    private ObtainabilityStrategy obtainInteract = null;
    private boolean interactObtainable = true;
    private ObtainabilityStrategy obtainLoot = null;
    private boolean lootObtainable = true;
    private ObtainabilityStrategy obtainExit = null;
    private boolean exitObtainable = true;

    private Room further;
    private Room back;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setInteract(String interact, ObtainabilityStrategy obtainInteract, String interactUnable) {
        this.interact = interact;
        this.obtainInteract = obtainInteract;
        this.interactUnable = interactUnable;
    }

    public void setLoot(String loot, ObtainabilityStrategy obtainLoot, String lootUnable) {
        this.loot = loot;
        this.obtainLoot = obtainLoot;
        this.lootUnable = lootUnable;
    }

    public void setExit(String exit, ObtainabilityStrategy obtainExit, String exitUnable) {
        this.exit = exit;
        this.obtainExit = obtainExit;
        this.exitUnable = exitUnable;
    }

    @Override
    public String getExit() {
        exitObtain();
        if (exitObtainable) {
            return exit;
        }
        else {
            return exitUnable;
        }
    }

    @Override
    public void exitObtain() {
        if (obtainExit != null) {
            exitObtainable = obtainExit.obtain(exitObtainable);
        }
    }

    @Override
    public String getInteract() {
        interactObtain();
        if (interactObtainable) {
            return interact;
        }
        else {
            return interactUnable;
        }
    }

    @Override
    public void interactObtain() {
        if (obtainInteract != null) {
            interactObtainable = obtainInteract.obtain(interactObtainable);
        }
    }

    @Override
    public String getLoot() {
        lootObtain();
        if (lootObtainable) {
            return loot;
        }
        else {
            return lootUnable;
        }
    }

    @Override
    public void lootObtain() {
        if (obtainLoot != null) {
            lootObtainable = obtainLoot.obtain(lootObtainable);
        }
    }

    public boolean isInteractObtainable() {
        interactObtain();
        return interactObtainable;
    }

    public boolean isLootObtainable() {
        lootObtain();
        return lootObtainable;
    }

    public boolean isExitObtainable() {
        exitObtain();
        return exitObtainable;
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

package edu.wctc;

public class ItemBoundStrategy implements ObtainabilityStrategy{
    // this is a strategy for when an item is needed
    Player player;
    String Item;

    public ItemBoundStrategy(Player player, String item) {
        this.player = player;
        Item = item;
    }

    @Override
    public boolean obtain(boolean initialObtainability) {
        if (player.getInventory().containsKey(Item)){
            return true;
        }
        else {
            return false;
        }
    }
}

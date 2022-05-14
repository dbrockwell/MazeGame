package edu.wctc;

public class ItemBoundStrategy implements ObtainabilityStrategy{
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

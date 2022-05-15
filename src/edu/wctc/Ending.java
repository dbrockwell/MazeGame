package edu.wctc;

import java.util.*;

public class Ending {
    private Player player;
    private int gemCount;
    private HashMap<String, Integer> inventory;
    private List<String> gems;

    public Ending(Player player) {
        this.player = player;
        inventory = player.getInventory();
        gems = new ArrayList<String>();
        for (GemColors i : GemColors.values()) {
            gems.add(i.getGemValue());
        }
    }

    public int getGemCount() {
        int gemCount = 0;
        for (String i : inventory.keySet()) {
            if (gems.contains(i)) {
                gemCount += inventory.get(i);
            }
        }
        this.gemCount = gemCount;
        return gemCount;
    }

    public String gemPrint() {
        if (gemCount == 1) {
            return "gem";
        }
        else {
            return "gems";
        }
    }

    public String rainbowAchievement() {
        if (inventory.containsKey("Red Gem") &&
                inventory.containsKey("Orange Gem") &&
                inventory.containsKey("Yellow Gem") &&
                inventory.containsKey("Green Gem") &&
                inventory.containsKey("Blue Gem") &&
                inventory.containsKey("Purple Gem")) {
            return "[Achievement Obtained] Colors of the rainbow - obtain all the gem colors that make up the colors of the rainbow";
        }
        else {
            return null;
        }
    }

    public String obtainAllAchievement() {
        if (inventory.containsKey("Red Gem") &&
                inventory.containsKey("Orange Gem") &&
                inventory.containsKey("Yellow Gem") &&
                inventory.containsKey("Green Gem") &&
                inventory.containsKey("Blue Gem") &&
                inventory.containsKey("Purple Gem") &&
                inventory.containsKey("Cyan Gem") &&
                inventory.containsKey("Magenta Gem") &&
                inventory.containsKey("Pink Gem") &&
                inventory.containsKey("White Gem") &&
                inventory.containsKey("Black Gem")){
            return "[Achievement Obtained] Color collector - obtain all the gem colors";
        }
        else {
            return null;
        }
    }

    public String gemCollectorAchievement() {
        if (gemCount >= 100){
            return "[Achievement Obtained] Gem collector - obtain 100 gems";
        }
        else {
            return null;
        }
    }

    public String gemGrinderAchievement() {
        if (gemCount >= 1000){
            return "[Achievement Obtained] Gem grinder - obtain 1000 gems";
        }
        else {
            return null;
        }
    }

    public String getEnding() {
        if (inventory.containsKey("Artifact") && inventory.containsKey("Black Gem")) {
            return """
                    Power Ending
                    Once you got out of the cave, the black gem and the artifact combined into one.
                    You thought nothing of it and went one with your day.
                    The next day you found it gone, you then realise that it was fused with you.
                    You then are able to use dark magic to bend anything to your will.
                    You become unstoppable, and increasingly unstable.""";
        }
        else if (inventory.containsKey("Artifact")) {
            return """
                    Unknown Death Ending
                    You leave the cave feeling uneasy, and looking down at the artifact you feel a power from it.
                    You set it down on the kitchen table looking at it wondering what powers it might be hiding.
                    You felt tired, but it was not getting late.
                    In the morning, you felt even worse, and blood came out of your mouth when you coughed.
                    When you went into the kitchen after getting up, the artifact is staring in your direction.
                    You can't stop staring at it, you start feeling dizzy, then you fall to the floor.""";
        }
        else if (gemCount >= 1000) {
            return """
                    Rich and Foolish Ending
                    You have exited the cave with so many gems it was hard to carry.
                    You started to sell these gems, and found they are worth a lot.
                    After selling all of this, you might be the richest man in the world.
                    After that prospect, you return to that cave without telling anyone about it, so that you can keep mining away.
                    Then one day, the cave lost so much support that it caved in on itself with you under the falling rock.""";
        }
        else if (gemCount >= 10) {
            return """
                    Good Man Ending
                    Right when you get out of that cave you started to sell those gems that you have found.
                    Any logger trying to mine for more gems you probably would have forgotten about the man trapped.
                    Once you have bought the right tools you make it back down to the cave to free him.
                    Luckily he was still doing fine, he was so glad to see you.
                    You break open the bars to free him and you bid each other farewell and go your separate ways.
                    To this day, you both keep in touch, living through life a good friends""";
        }
        else {
            return """
                    Normal Life Ending
                    After the experience within the cave, you never want to go into caves ever again.                    
                    You feel like you didn't obtain much of anything in your journey.
                    After months of being at home, you looked at that pickaxe in the corner and it made you think of that man.
                    Oh no, that man.
                    You get back to that cave, even though you never wanted to enter a cave ever again.
                    When you enter you find a body with only rotting flesh and bone, with the flask next to him.""";
        }
    }
}

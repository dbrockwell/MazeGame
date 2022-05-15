package edu.wctc;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Person {
    Player player;
    private static Person instance = null;
    private boolean firstIntroduction = false;
    private boolean firstBackstory = false;
    private boolean firstObjective = false;
    private boolean objectiveComplete = false;

    public Person(Player player) {
        this.player = player;
    }

    public String getIntroduction() {
        if (!firstIntroduction) {
            firstIntroduction = true;
            return "Finally, someone has found me. I have been stuck down here for a while.";
        }
        else if (objectiveComplete) {
            return "Hello again, hope you get out of this cave.";
        }
        else if (firstObjective) {
            return "Hello again, have you found my flask yet?";
        }
        else {
            return "Hello again";
        }
    }

    public List<String> getPromptList() {
        List<String> prompts = new ArrayList<>();
        if (!firstBackstory) {
            prompts.add("How did you get trapped in there?");
        }
        if (!firstObjective) {
            prompts.add("Could I use that Pickaxe you have?");
        }
        if (firstObjective && player.getInventory().containsKey("Flask")) {
            prompts.add("I have found your flask");
        }
        return prompts;
    }

    public String showPrompt() {
        List<String> prompts = getPromptList();
        String finalPrompt = "";
        for (String p : prompts) {
             finalPrompt += format("%s ) %s\n", prompts.indexOf(p) + 1, p);
        }
        return finalPrompt;
    }

    public String answerPrompt(int promptNumber) {
        List<String> prompts = getPromptList();
        if (prompts.indexOf("How did you get trapped in there?") + 1 == promptNumber) {
            return getBackstory();
        }
        else if (prompts.indexOf("Could I use that Pickaxe you have?") + 1 == promptNumber) {
            return getObjective();
        }
        else if (prompts.indexOf("I have found your flask") + 1 == promptNumber) {
            return completeObjective();
        }
        else {
            return null;
        }
    }

    public String getBackstory() {
        firstBackstory = true;
        return """
                    I have accidentally pressed a button on the wall and these bars came up from the ground.
                    I tried to break myself out with no avail.""";
    }

    public String getObjective() {
        firstObjective = true;
        return "I will give you my pickaxe if you could find my flask in the room with the gems.";
    }

    public String completeObjective() {
        objectiveComplete = true;
        player.replaceInventoryItem("Flask", Pickaxe.getInstance().getPickaxe());
        return "Thank for getting me my flask, here is the pickaxe";
    }
    //The person can only have one instance as in singleton
    public static Person getInstance(Player player) {
        if (instance == null) {
            synchronized (Flask.class) {
                if (instance == null) {
                    instance = new Person(player);
                }
            }
        }

        return instance;
    }
}

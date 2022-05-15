package edu.wctc;

import edu.wctc.*;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class Testing {
    // here are the junit tests for achievements and endings
    @Test
    public void testRainbowAchievement() {
        HashMap<String, Integer> testInventory = new HashMap<>();
        testInventory.put("Red Gem", 3);
        testInventory.put("Orange Gem", 2);
        testInventory.put("Yellow Gem", 4);
        testInventory.put("Green Gem", 2);
        testInventory.put("Blue Gem", 5);
        testInventory.put("Purple Gem", 1);
        testInventory.put("White Gem", 1);
        Player player = new Player();
        Ending ending = new Ending(player);
        ending.testEnding(testInventory);
        assertNotNull(ending.rainbowAchievement());
        testInventory = new HashMap<>();
        testInventory.put("Red Gem", 3);
        testInventory.put("Orange Gem", 2);
        testInventory.put("Yellow Gem", 4);
        testInventory.put("Green Gem", 2);
        testInventory.put("Purple Gem", 1);
        testInventory.put("White Gem", 1);
        ending.testEnding(testInventory);
        assertNull(ending.rainbowAchievement());
    }

    @Test
    public void testObtainAllAchievement() {
        HashMap<String, Integer> testInventory = new HashMap<>();
        testInventory.put("Red Gem", 3);
        testInventory.put("Orange Gem", 2);
        testInventory.put("Yellow Gem", 4);
        testInventory.put("Green Gem", 2);
        testInventory.put("Blue Gem", 5);
        testInventory.put("Purple Gem", 1);
        testInventory.put("White Gem", 1);
        testInventory.put("Pink Gem", 4);
        testInventory.put("Black Gem", 2);
        testInventory.put("Cyan Gem", 3);
        testInventory.put("Magenta Gem", 4);
        Player player = new Player();
        Ending ending = new Ending(player);
        ending.testEnding(testInventory);
        assertNotNull(ending.obtainAllAchievement());
        testInventory = new HashMap<>();
        testInventory.put("Red Gem", 3);
        testInventory.put("Orange Gem", 2);
        testInventory.put("Yellow Gem", 4);
        testInventory.put("Green Gem", 2);
        testInventory.put("Blue Gem", 5);
        testInventory.put("Purple Gem", 1);
        testInventory.put("White Gem", 1);
        testInventory.put("Pink Gem", 4);
        testInventory.put("Black Gem", 2);
        testInventory.put("Cyan Gem", 3);
        ending.testEnding(testInventory);
        assertNull(ending.obtainAllAchievement());
    }
    @Test
    public void testGemCollectorAchievement() {
        HashMap<String, Integer> testInventory = new HashMap<>();
        testInventory.put("Red Gem", 10);
        testInventory.put("Orange Gem", 10);
        testInventory.put("Yellow Gem", 10);
        testInventory.put("Green Gem", 10);
        testInventory.put("Blue Gem", 10);
        testInventory.put("Purple Gem", 10);
        testInventory.put("White Gem", 10);
        testInventory.put("Pink Gem", 10);
        testInventory.put("Black Gem", 10);
        testInventory.put("Cyan Gem", 10);
        testInventory.put("Magenta Gem", 10);
        Player player = new Player();
        Ending ending = new Ending(player);
        ending.testEnding(testInventory);
        ending.getGemCount();
        assertNotNull(ending.gemCollectorAchievement());
        testInventory = new HashMap<>();
        testInventory.put("Red Gem", 3);
        testInventory.put("Orange Gem", 2);
        testInventory.put("Yellow Gem", 4);
        testInventory.put("Green Gem", 2);
        testInventory.put("Blue Gem", 5);
        testInventory.put("Purple Gem", 1);
        testInventory.put("White Gem", 1);
        testInventory.put("Pink Gem", 4);
        testInventory.put("Black Gem", 2);
        testInventory.put("Cyan Gem", 3);
        ending.testEnding(testInventory);
        ending.getGemCount();
        assertNull(ending.gemCollectorAchievement());
    }
    @Test
    public void testGemGrinderAchievement() {
        HashMap<String, Integer> testInventory = new HashMap<>();
        testInventory.put("Red Gem", 100);
        testInventory.put("Orange Gem", 100);
        testInventory.put("Yellow Gem", 100);
        testInventory.put("Green Gem", 100);
        testInventory.put("Blue Gem", 100);
        testInventory.put("Purple Gem", 100);
        testInventory.put("White Gem", 100);
        testInventory.put("Pink Gem", 100);
        testInventory.put("Black Gem", 100);
        testInventory.put("Cyan Gem", 100);
        testInventory.put("Magenta Gem", 100);
        Player player = new Player();
        Ending ending = new Ending(player);
        ending.testEnding(testInventory);
        ending.getGemCount();
        assertNotNull(ending.gemGrinderAchievement());
        testInventory = new HashMap<>();
        testInventory.put("Red Gem", 30);
        testInventory.put("Orange Gem", 20);
        testInventory.put("Yellow Gem", 40);
        testInventory.put("Green Gem", 20);
        testInventory.put("Blue Gem", 50);
        testInventory.put("Purple Gem", 10);
        testInventory.put("White Gem", 10);
        testInventory.put("Pink Gem", 40);
        testInventory.put("Black Gem", 20);
        testInventory.put("Cyan Gem", 30);
        ending.testEnding(testInventory);
        ending.getGemCount();
        assertNull(ending.gemGrinderAchievement());
    }

    @Test
    public void testEnding() {
        HashMap<String, Integer> testInventory = new HashMap<>();
        testInventory.put("Black Gem", 1);
        testInventory.put("Pink Gem", 2);
        testInventory.put("Artifact", 1);
        Player player = new Player();
        Ending ending = new Ending(player);
        ending.testEnding(testInventory);
        ending.getGemCount();
        assertTrue(ending.getEnding().contains("Power Ending"));
        testInventory = new HashMap<>();
        testInventory.put("Red Gem", 3);
        testInventory.put("Orange Gem", 2);
        testInventory.put("Yellow Gem", 4);
        testInventory.put("Artifact", 1);
        ending.testEnding(testInventory);
        ending.getGemCount();
        assertTrue(ending.getEnding().contains("Unknown Death Ending"));
        testInventory = new HashMap<>();
        testInventory.put("Red Gem", 100);
        testInventory.put("Orange Gem", 100);
        testInventory.put("Yellow Gem", 100);
        testInventory.put("Green Gem", 100);
        testInventory.put("Blue Gem", 100);
        testInventory.put("Purple Gem", 100);
        testInventory.put("White Gem", 100);
        testInventory.put("Pink Gem", 100);
        testInventory.put("Black Gem", 100);
        testInventory.put("Cyan Gem", 100);
        testInventory.put("Magenta Gem", 100);
        ending.testEnding(testInventory);
        ending.getGemCount();
        assertTrue(ending.getEnding().contains("Rich and Foolish Ending"));
        testInventory = new HashMap<>();
        testInventory.put("Red Gem", 3);
        testInventory.put("Orange Gem", 2);
        testInventory.put("Yellow Gem", 4);
        testInventory.put("Cyan Gem", 5);
        ending.testEnding(testInventory);
        ending.getGemCount();
        assertTrue(ending.getEnding().contains("Good Man Ending"));
        testInventory = new HashMap<>();
        testInventory.put("Red Gem", 3);
        testInventory.put("Orange Gem", 2);
        testInventory.put("Yellow Gem", 4);
        ending.testEnding(testInventory);
        ending.getGemCount();
        assertTrue(ending.getEnding().contains("Normal Life Ending"));
    }
}
